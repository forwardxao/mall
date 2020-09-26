package com.mytool.farm.service;

import com.mytool.farm.model.FarmItem ; 
import java.util.List;
/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-26 18:23:00
 */ 
public interface FarmItemService{

     int create(FarmItem farmItem);

     int update(FarmItem farmItem);

     int delete(Integer id);

     FarmItem getItem(Integer id);

     /*page search list*/

     List<FarmItem> list(Integer pageSize, Integer pageNum);

}

