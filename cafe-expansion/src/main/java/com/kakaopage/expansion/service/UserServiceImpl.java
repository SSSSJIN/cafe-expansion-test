package com.kakaopage.expansion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaopage.expansion.dao.UserMapper;
import com.kakaopage.expansion.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserVO findByKakaoId(String kakaoId) {
        return mapper.findByKakaoId(kakaoId);
    }

    @Override
    public void save(UserVO user) {
        mapper.insert(user);
    }
}
