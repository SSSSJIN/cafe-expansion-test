package com.kakaopage.expansion.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.kakaopage.expansion.vo.MainEventVO;

@Mapper
public interface MainEventDAO {
    /**
     * 메인 이벤트 목록 조회
     * @return MainEventVO 리스트
     */
    List<MainEventVO> selectMainEvents();
}
