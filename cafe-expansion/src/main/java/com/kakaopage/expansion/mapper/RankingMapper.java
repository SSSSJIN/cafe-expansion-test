package com.kakaopage.expansion.mapper;

import java.util.List;
import com.kakaopage.expansion.vo.BookVO;

public interface RankingMapper {
    /** HOT_FLAG=1인 게시글에서 인기 책 top10 (예시) */
    List<BookVO> selectHotBooks();
}
