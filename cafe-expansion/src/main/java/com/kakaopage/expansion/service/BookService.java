package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.BookVO;
import java.util.List;

public interface BookService {
    List<BookVO> getHotBooks();
    List<BookVO> getRankingBooks();
    List<BookVO> getRecentBooks(Long userId);
    List<BookVO> getAllBooks();
    BookVO      getBookById(Long id);
    List<BookVO> getBooksByTitle(String title);
    int          insertBook(BookVO book);
    int          updateThumbnail(Long id, String thumbnail);  // 반드시 선언!
}
