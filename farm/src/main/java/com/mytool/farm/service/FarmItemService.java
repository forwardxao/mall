package com.mytool.farm.service;

import com.mytool.model.FarmItem ; 
import java.util.List;
/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-23 19:16:19
 */ 
public interface FarmItemService{

     int create(FarmItem farmItem);

     int update(Long id,FarmItem farmItem);

     int delete(Long id);

     FarmItem getItem(Long id);

     /*page search list*/

     List<FarmItem> list(Integer pageSize, Integer pageNum);

}

