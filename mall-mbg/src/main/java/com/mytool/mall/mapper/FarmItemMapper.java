package com.mytool.mall.mapper;

import com.mytool.mall.model.FarmItem;
import com.mytool.mall.model.FarmItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FarmItemMapper {
    long countByExample(FarmItemExample example);

    int deleteByExample(FarmItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FarmItem record);

    int insertSelective(FarmItem record);

    List<FarmItem> selectByExample(FarmItemExample example);

    FarmItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FarmItem record, @Param("example") FarmItemExample example);

    int updateByExample(@Param("record") FarmItem record, @Param("example") FarmItemExample example);

    int updateByPrimaryKeySelective(FarmItem record);

    int updateByPrimaryKey(FarmItem record);
}