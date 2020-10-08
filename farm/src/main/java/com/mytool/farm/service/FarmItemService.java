package com.mytool.farm.service;

import com.mytool.farm.model.FarmItem ; 
import java.util.List;
/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-10-08 18:38:49
 */ 
public interface FarmItemService{

     int create(FarmItem farmItem);

     int update(Integer id,FarmItem farmItem);

     int delete(Integer id);

     FarmItem getItem(Integer id);

     /*page search list*/

     List<FarmItem> list(Integer id,Integer pageSize, Integer pageNum);

}

