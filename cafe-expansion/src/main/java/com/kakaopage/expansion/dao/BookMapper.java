package com.kakaopage.expansion.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.kakaopage.expansion.vo.BookVO;

@Mapper
public interface BookMapper {
    List<BookVO> getHotBooks();
    List<BookVO> getRankingBooks();
    List<BookVO> getRecentBooks(@Param("userId") Long userId);
    List<BookVO> getAllBooks();
    BookVO      getBookById(@Param("id") Long id);
    List<BookVO> getBooksByTitle(@Param("title") String title);
    int          insertBook(BookVO book);
    int updateThumbnail(@Param("id") Long id,
                        @Param("thumbnail") String thumbnail);
}
