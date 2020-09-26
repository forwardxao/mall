package com.mytool.farm.service.impl;

import com.mytool.farm.model.FarmItem ; 
import org.springframework.beans.factory.annotation.Autowired;
import com.mytool.farm.service.FarmItemService ; 
import com.mytool.farm.mapper.FarmItemMapper ; 
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;
import org.springframework.stereotype.Service;
/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-26 18:23:00
 */ 
@Service
public class FarmItemServiceImpl  implements FarmItemService{

	@Autowired
	FarmItemMapper farmItemMapper ;

	@Autowired
	public int create(FarmItem farmItem) {
		farmItem.setCreate_time((int)new Date().getTime()/1000);
		return farmItemMapper.insert(farmItem);
	}

	@Autowired
	public int update(FarmItem farmItem) {
		farmItem.setUpdate_time((int)new Date().getTime()/1000);
		return farmItemMapper.update(farmItem);
	}

	@Autowired
	public int delete(Integer id) {
		return farmItemMapper.delete(id);
	}

	@Autowired
	public FarmItem getItem(Integer id) {
		return farmItemMapper.getItem(id);
	}

	@Autowired
	public List<FarmItem> list(Integer pageNum,Integer pageSize) {
		return farmItemMapper.list(pageNum,pageSize);
	}

}

