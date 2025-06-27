package com.kakaopage.expansion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaopage.expansion.dao.MainEventDAO;
import com.kakaopage.expansion.vo.MainEventVO;

@Service
public class MainEventService {
    @Autowired
    private MainEventDAO dao;

    public List<MainEventVO> getMainEvents() {
        return dao.selectMainEvents();
    }
}
