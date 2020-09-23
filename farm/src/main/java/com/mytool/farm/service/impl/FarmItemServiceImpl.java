package com.mytool.farm.service.impl;

import com.mytool.farm.model.FarmItem ; 
import org.springframework.beans.factory.annotation.Autowired;
import com.mytool.farm.service.FarmItemService ; 
import com.mytool.farm.mapper.FarmItemMapper ; 
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.stereotype.Service;
/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-23 19:16:19
 */ 
@Service
public class FarmItemServiceImpl  implements FarmItemService{

@Autowired
FarmItemMapper farmItemMapper ;

@Autowired
public int create(FarmItem farmItem) {
     farmItem.setCreateTime(new Date());
     return farmItemMapper.insert(farmItem);
}
}

