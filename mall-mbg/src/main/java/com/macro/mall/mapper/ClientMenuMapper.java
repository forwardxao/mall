package com.macro.mall.mapper;

import com.macro.mall.model.ClientMenu;
import com.macro.mall.model.ClientMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientMenuMapper {
    long countByExample(ClientMenuExample example);

    int deleteByExample(ClientMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClientMenu record);

    int insertSelective(ClientMenu record);

    List<ClientMenu> selectByExample(ClientMenuExample example);

    ClientMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClientMenu record, @Param("example") ClientMenuExample example);

    int updateByExample(@Param("record") ClientMenu record, @Param("example") ClientMenuExample example);

    int updateByPrimaryKeySelective(ClientMenu record);

    int updateByPrimaryKey(ClientMenu record);
}