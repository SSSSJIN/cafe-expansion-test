package com.kakaopage.expansion.vo;

public class UserVO {
    private Long id;
    private String username;
    private String password;   // 카카오 로그인만 쓸 경우 null 가능
    private String role;
    private String kakaoId;    // 카카오 회원 고유번호
    private String nickname;   // 카카오 닉네임

    // --- Getter/Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getKakaoId() { return kakaoId; }
    public void setKakaoId(String kakaoId) { this.kakaoId = kakaoId; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
}
