package com.mytool.farm.mapper;
import com.mytool.farm.model.FarmItem ; 
import com.mytool.farm.model.FarmItemExample ; 
import java.util.List;

/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-10-08 18:38:49
 */ 
public interface FarmItemMapper{

	int insert(FarmItem model);

	int update(Integer id,FarmItem model);

	int delete(Integer id);

	FarmItem getItem(Integer id);

	List<FarmItem> list(FarmItemExample example);

}

