package com.mytool.mapper;

import com.mytool.model.MyFarm;
import com.mytool.model.MyFarmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyFarmMapper {
    long countByExample(MyFarmExample example);

    int deleteByExample(MyFarmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MyFarm record);

    int insertSelective(MyFarm record);

    List<MyFarm> selectByExample(MyFarmExample example);

    MyFarm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MyFarm record, @Param("example") MyFarmExample example);

    int updateByExample(@Param("record") MyFarm record, @Param("example") MyFarmExample example);

    int updateByPrimaryKeySelective(MyFarm record);

    int updateByPrimaryKey(MyFarm record);
}