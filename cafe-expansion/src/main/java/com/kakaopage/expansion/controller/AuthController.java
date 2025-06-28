package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.UserService;
import com.kakaopage.expansion.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 인증(로그인/회원가입) 관련 컨트롤러
 */
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // 카카오 REST API Key (appkey)
    private static final String KAKAO_CLIENT_ID = "e8da3210f814e01f61a25d163730ebd2";
    // 카카오 Redirect URI (카카오 개발자센터 등록 필요)
    private static final String KAKAO_REDIRECT_URI = "http://localhost:8080/cafe-expansion/kakao-callback";

    /**
     * 카카오 로그인 콜백
     * 인가코드로 토큰 발급 → 사용자 정보 조회 → 회원 등록/조회 → 세션 저장 → 홈으로 이동
     */
    @GetMapping("/kakao-callback")
    public String kakaoCallback(@RequestParam("code") String code, HttpSession session, Model model) {
        try {
            // 1. 인가코드로 토큰 요청
            RestTemplate restTemplate = new RestTemplate();
            String tokenUrl = "https://kauth.kakao.com/oauth/token";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            String body = "grant_type=authorization_code"
                    + "&client_id=" + KAKAO_CLIENT_ID
                    + "&redirect_uri=" + KAKAO_REDIRECT_URI
                    + "&code=" + code;

            HttpEntity<String> request = new HttpEntity<>(body, headers);
            ResponseEntity<String> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, request, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode tokenJson = objectMapper.readTree(response.getBody());
            String accessToken = tokenJson.get("access_token").asText();

            // 2. 토큰으로 사용자 정보 요청
            String userInfoUrl = "https://kapi.kakao.com/v2/user/me";
            HttpHeaders userHeaders = new HttpHeaders();
            userHeaders.add("Authorization", "Bearer " + accessToken);
            HttpEntity<String> userRequest = new HttpEntity<>(userHeaders);
            ResponseEntity<String> userResponse = restTemplate.exchange(userInfoUrl, HttpMethod.GET, userRequest, String.class);
            JsonNode userJson = objectMapper.readTree(userResponse.getBody());

            String kakaoId = userJson.get("id").asText();
            String email = userJson.path("kakao_account").path("email").asText("");
            String nickname = userJson.path("properties").path("nickname").asText("");

            // 3. 회원 여부 확인/등록
            UserVO user = userService.findByKakaoId(kakaoId);
            if (user == null) {
                user = new UserVO();
                user.setKakaoId(kakaoId);
                user.setUsername(email.isEmpty() ? nickname : email);
                user.setNickname(nickname);
                user.setRole("USER");
                userService.save(user);
            }
            session.setAttribute("user", user);
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "카카오 로그인 실패: " + e.getMessage());
            return "login";
        }
    }

    // ---- 아래는 기존 로컬/폼/JSON 로그인·회원가입 코드, 추후 확장 시 복구 가능 ----

    /*
    // 로그인 폼 페이지
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // /WEB-INF/views/login.jsp
    }

    // 회원가입 폼 페이지
    @GetMapping("/signup")
    public String signupForm() {
        return "signup"; // /WEB-INF/views/signup.jsp
    }

    // === [1] 일반 폼 전송(HTML form) 방식 지원 ===
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {
        UserVO user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "login";
        }
    }

    @PostMapping("/signup")
    public String signup(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "이미 존재하는 아이디입니다.");
            return "signup";
        }
        UserVO user = new UserVO();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("USER");
        userService.save(user);
        return "redirect:/login";
    }

    // === [2] 기존 JSON 방식(AJAX) ===
    @PostMapping("/api/auth/login")
    @ResponseBody
    public String loginApi(@RequestBody UserVO user, HttpSession session) {
        UserVO dbUser = userService.findByUsername(user.getUsername());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", dbUser);
            return "{\"result\":\"success\"}";
        } else {
            return "{\"result\":\"fail\"}";
        }
    }

    @PostMapping("/api/auth/signup")
    @ResponseBody
    public String signupApi(@RequestBody UserVO user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return "{\"result\":\"duplicate\"}";
        }
        user.setRole("USER");
        userService.save(user);
        return "{\"result\":\"success\"}";
    }
    */

}
