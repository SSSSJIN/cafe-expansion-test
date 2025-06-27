package com.kakaopage.expansion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaopage.expansion.mapper.RankingMapper;
import com.kakaopage.expansion.service.RankingService;
import com.kakaopage.expansion.vo.BookVO;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private RankingMapper rankingMapper;

    @Override
    public List<BookVO> getHotBooks() {
        return rankingMapper.selectHotBooks();
    }
}
