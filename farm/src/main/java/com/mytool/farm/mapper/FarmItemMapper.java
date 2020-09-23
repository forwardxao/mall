package com.mytool.farm.mapper;
import org.apache.ibatis.annotations.Insert;  
import org.apache.ibatis.annotations.Update;  
import org.springframework.stereotype.Component;  
import com.mytool.farm.entity.FarmItem ; 
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-23 19:16:19
 */ 
@Component
public interface FarmItemMapper{


int insertFarmItem(FarmItem model);

}

