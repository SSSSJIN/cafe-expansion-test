package com.kakaopage.expansion.controller;

import com.kakaopage.expansion.service.BookService;
import com.kakaopage.expansion.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final BookService bookService;

    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 메인화면: "/" 또는 "/home" 으로 접근 가능
     * - 지금 핫한, 실시간 랭킹, 최근 본 목록 모두 DB 연동
     */
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        // DB에서 핫한 작품, 랭킹, 최근 본 목록 조회
        List<BookVO> hotBooks     = bookService.getHotBooks();
        List<BookVO> rankingBooks = bookService.getRankingBooks();
        // 예시: userId=1로 최근 본 목록 조회 (실제 로그인 연동 시 세션에서 userId 꺼내기)
        List<BookVO> recentBooks  = bookService.getRecentBooks(1L);

        model.addAttribute("hotBooks",     hotBooks);
        model.addAttribute("rankingBooks", rankingBooks);
        model.addAttribute("recentBooks",  recentBooks);

        return "home";  // /WEB-INF/views/home.jsp
    }

    /**
     * 보관함 페이지 이동
     */
    @GetMapping("/mybooks")
    public String mybooks() {
        return "mybooks"; // /WEB-INF/views/mybooks.jsp
    }

    /**
     * 최근 본 목록 페이지 이동
     */
    @GetMapping("/recent")
    public String recent() {
        return "recent"; // /WEB-INF/views/recent.jsp
    }

    /**
     * 상세 페이지 이동 (DB 연동)
     * bookId로 BookVO 조회해서 model에 담기
     */
    @GetMapping("/detail")
    public String detail(@RequestParam("bookId") Long bookId, Model model) {
        BookVO book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "detail"; // /WEB-INF/views/detail.jsp
    }
}
