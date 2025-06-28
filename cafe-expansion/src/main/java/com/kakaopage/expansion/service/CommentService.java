package com.kakaopage.expansion.service;

import com.kakaopage.expansion.vo.CommentVO;
import java.util.List;

public interface CommentService {
    void add(CommentVO vo);
    List<CommentVO> getCommentsByBoard(Long boardId);
    void removeComment(Long commentId);
}
