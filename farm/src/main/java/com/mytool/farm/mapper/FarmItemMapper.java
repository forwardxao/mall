package com.mytool.farm.mapper;
import com.mytool.farm.model.FarmItem ; 
import java.util.List;

/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-26 18:23:00
 */ 
public interface FarmItemMapper{

	int insert(FarmItem model);

	int update(FarmItem model);

	int delete(Integer id);

	FarmItem getItem(Integer id);

	List<FarmItem> list(Integer pageNum,Integer pageSize);

}

