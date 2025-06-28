package com.kakaopage.expansion.service;

import com.kakaopage.expansion.dao.BookMapper;
import com.kakaopage.expansion.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookVO> getHotBooks() {
        return bookMapper.getHotBooks();
    }

    @Override
    public List<BookVO> getRankingBooks() {
        return bookMapper.getRankingBooks();
    }

    @Override
    public List<BookVO> getRecentBooks(Long userId) {
        return bookMapper.getRecentBooks(userId);
    }

    @Override
    public List<BookVO> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public BookVO getBookById(Long id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public List<BookVO> getBooksByTitle(String title) {
        return bookMapper.getBooksByTitle(title);
    }

    @Override
    public int insertBook(BookVO book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public int updateThumbnail(Long id, String thumbnail) {
        return bookMapper.updateThumbnail(id, thumbnail);
    }
}
