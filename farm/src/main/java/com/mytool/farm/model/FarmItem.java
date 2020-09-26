package com.mytool.farm.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-26 18:23:00
 */ 
public class FarmItem implements Serializable {

	@ApiModelProperty(value = "主键")
	private Integer id;
	@ApiModelProperty(value = "农场名")
	private String farm_name;
	@ApiModelProperty(value = "农场主名称")
	private String user_name;
	@ApiModelProperty(value = "具体地址")
	private String address;
	@ApiModelProperty(value = "省")
	private String province;
	@ApiModelProperty(value = "世")
	private String city;
	@ApiModelProperty(value = "区/县")
	private String area;
	@ApiModelProperty(value = "创建时间")
	private Integer create_time;
	@ApiModelProperty(value = "更新时间")
	private Integer update_time;
	private static final long serialVersionUID = 1L;

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setFarm_name(String farm_name){
		this.farm_name=farm_name;
	}
	public String getFarm_name(){
		return farm_name;
	}
	public void setUser_name(String user_name){
		this.user_name=user_name;
	}
	public String getUser_name(){
		return user_name;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setProvince(String province){
		this.province=province;
	}
	public String getProvince(){
		return province;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getCity(){
		return city;
	}
	public void setArea(String area){
		this.area=area;
	}
	public String getArea(){
		return area;
	}
	public void setCreate_time(Integer create_time){
		this.create_time=create_time;
	}
	public Integer getCreate_time(){
		return create_time;
	}
	public void setUpdate_time(Integer update_time){
		this.update_time=update_time;
	}
	public Integer getUpdate_time(){
		return update_time;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", farm_name=").append(farm_name);
		sb.append(", user_name=").append(user_name);
		sb.append(", address=").append(address);
		sb.append(", province=").append(province);
		sb.append(", city=").append(city);
		sb.append(", area=").append(area);
		sb.append(", create_time=").append(create_time);
		sb.append(", update_time=").append(update_time);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}

