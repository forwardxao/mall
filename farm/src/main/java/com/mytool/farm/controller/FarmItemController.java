package com.mytool.farm.controller;
 
import com.mytool.common.api.CommonPage;  
import com.mytool.common.api.CommonResult;  
import com.mytool.model.FarmItem ; 
import com.mytool.farm.service.FarmItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-26 18:23:00
 */
@Controller
@Api(value = "FarmItemController", description = "FarmItemController")
@RequestMapping("/FarmItem")
public class FarmItemController{

    @Autowired
    FarmItemService service;

    @ApiOperation("create one item")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult create(@RequestBody FarmItem farmItem) {
        int count = service.create(farmItem);
        if (count > 0) {
             return CommonResult.success(count);
        } else {
             return CommonResult.failed();
        }
    }

    @ApiOperation("update item info")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult update(@PathVariable Integer id,
                               @RequestBody FarmItem farmItem) {
        int count = service.update(id,farmItem);
        if (count > 0) {
             return CommonResult.success(count);
        } else {
             return CommonResult.failed();
        }
    }

    @ApiOperation("delete item by id")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public CommonResult delete(@PathVariable Integer id) {
        int count = service.delete(id);
        if (count > 0) {
             return CommonResult.success(count);
        } else {
             return CommonResult.failed();
        }
    }

    @ApiOperation("get detail")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult<FarmItem> getItem(@PathVariable Integer id){
         FarmItem farmItem=service.getItem(id);
         return CommonResult.success(farmItem);
    }

    @ApiOperation("get list by page")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<FarmItem>> list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
         List<FarmItem> itemList = service.list(pageSize, pageNum);
         return CommonResult.success(CommonPage.restPage(itemList));
    }

}

