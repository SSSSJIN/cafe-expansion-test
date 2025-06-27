package com.kakaopage.expansion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kakaopage.expansion.service.MainEventService;
import com.kakaopage.expansion.service.RankingService;
import com.kakaopage.expansion.vo.MainEventVO;
import com.kakaopage.expansion.vo.BookVO;

@Controller
public class HomeController {

    private final MainEventService mainEventService;
    private final RankingService rankingService;

    @Autowired
    public HomeController(MainEventService mainEventService,
                          RankingService rankingService) {
        this.mainEventService = mainEventService;
        this.rankingService   = rankingService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        // 메인 이벤트
        List<MainEventVO> events = mainEventService.getMainEvents();
        model.addAttribute("mainEvents", events);
        // 실시간 랭킹
        List<BookVO> hotBooks = rankingService.getHotBooks();
        model.addAttribute("hotBooks", hotBooks);

        return "home";
    }
}
