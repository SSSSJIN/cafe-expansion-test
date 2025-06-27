package com.kakaopage.expansion.service;

import java.util.List;
import com.kakaopage.expansion.vo.BookVO;

public interface RankingService {
    /** 실시간 인기 도서 리스트 조회 (상위 10개 예시) */
    List<BookVO> getHotBooks();
}
