package com.kakaopage.expansion.dao;

import org.apache.ibatis.annotations.Mapper;
import com.kakaopage.expansion.vo.UserVO;

@Mapper
public interface UserMapper {
    UserVO findByKakaoId(String kakaoId);
    void insert(UserVO user);
}
