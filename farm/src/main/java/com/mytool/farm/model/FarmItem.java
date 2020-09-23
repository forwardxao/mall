package com.mytool.farm.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * table name:  farm_item
 * author name: mytool
 * create time: 2020-09-23 19:16:19
 */ 
public class FarmItem implements Serializable {

	@ApiModelProperty(value = "主键")
	private Integer id;
	@ApiModelProperty(value = "农场名")
	private String farm_name;
	@ApiModelProperty(value = "农场主名称")
	private String name;
	@ApiModelProperty(value = "具体地址")
	private String address;
	@ApiModelProperty(value = "图一")
	private String image;
	private String image_title;
	private String image2;
	private String image2_title;
	private String image3;
	private String image3_title;
	private String image4;
	private String image4_title;
	private String image5;
	private String image5_title;
	@ApiModelProperty(value = "视频一")
	private String video;
	private String video_title;
	private String video2;
	private String video2_title;
	private String video3;
	private String video3_title;
	private String video4;
	private String video4_title;
	private String video5;
	private String video5_title;
	@ApiModelProperty(value = "省")
	private String province;
	@ApiModelProperty(value = "世")
	private String city;
	@ApiModelProperty(value = "区/县")
	private String area;
	private static final long serialVersionUID = 1L;

	public FarmItem() {
		super();
	}
	public FarmItem(Integer id,String farm_name,String name,String address,String image,String image_title,String image2,String image2_title,String image3,String image3_title,String image4,String image4_title,String image5,String image5_title,String video,String video_title,String video2,String video2_title,String video3,String video3_title,String video4,String video4_title,String video5,String video5_title,String province,String city,String area) {
		this.id=id;
		this.farm_name=farm_name;
		this.name=name;
		this.address=address;
		this.image=image;
		this.image_title=image_title;
		this.image2=image2;
		this.image2_title=image2_title;
		this.image3=image3;
		this.image3_title=image3_title;
		this.image4=image4;
		this.image4_title=image4_title;
		this.image5=image5;
		this.image5_title=image5_title;
		this.video=video;
		this.video_title=video_title;
		this.video2=video2;
		this.video2_title=video2_title;
		this.video3=video3;
		this.video3_title=video3_title;
		this.video4=video4;
		this.video4_title=video4_title;
		this.video5=video5;
		this.video5_title=video5_title;
		this.province=province;
		this.city=city;
		this.area=area;
	}
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
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setImage(String image){
		this.image=image;
	}
	public String getImage(){
		return image;
	}
	public void setImage_title(String image_title){
		this.image_title=image_title;
	}
	public String getImage_title(){
		return image_title;
	}
	public void setImage2(String image2){
		this.image2=image2;
	}
	public String getImage2(){
		return image2;
	}
	public void setImage2_title(String image2_title){
		this.image2_title=image2_title;
	}
	public String getImage2_title(){
		return image2_title;
	}
	public void setImage3(String image3){
		this.image3=image3;
	}
	public String getImage3(){
		return image3;
	}
	public void setImage3_title(String image3_title){
		this.image3_title=image3_title;
	}
	public String getImage3_title(){
		return image3_title;
	}
	public void setImage4(String image4){
		this.image4=image4;
	}
	public String getImage4(){
		return image4;
	}
	public void setImage4_title(String image4_title){
		this.image4_title=image4_title;
	}
	public String getImage4_title(){
		return image4_title;
	}
	public void setImage5(String image5){
		this.image5=image5;
	}
	public String getImage5(){
		return image5;
	}
	public void setImage5_title(String image5_title){
		this.image5_title=image5_title;
	}
	public String getImage5_title(){
		return image5_title;
	}
	public void setVideo(String video){
		this.video=video;
	}
	public String getVideo(){
		return video;
	}
	public void setVideo_title(String video_title){
		this.video_title=video_title;
	}
	public String getVideo_title(){
		return video_title;
	}
	public void setVideo2(String video2){
		this.video2=video2;
	}
	public String getVideo2(){
		return video2;
	}
	public void setVideo2_title(String video2_title){
		this.video2_title=video2_title;
	}
	public String getVideo2_title(){
		return video2_title;
	}
	public void setVideo3(String video3){
		this.video3=video3;
	}
	public String getVideo3(){
		return video3;
	}
	public void setVideo3_title(String video3_title){
		this.video3_title=video3_title;
	}
	public String getVideo3_title(){
		return video3_title;
	}
	public void setVideo4(String video4){
		this.video4=video4;
	}
	public String getVideo4(){
		return video4;
	}
	public void setVideo4_title(String video4_title){
		this.video4_title=video4_title;
	}
	public String getVideo4_title(){
		return video4_title;
	}
	public void setVideo5(String video5){
		this.video5=video5;
	}
	public String getVideo5(){
		return video5;
	}
	public void setVideo5_title(String video5_title){
		this.video5_title=video5_title;
	}
	public String getVideo5_title(){
		return video5_title;
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
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", farm_name=").append(farm_name);
		sb.append(", name=").append(name);
		sb.append(", address=").append(address);
		sb.append(", image=").append(image);
		sb.append(", image_title=").append(image_title);
		sb.append(", image2=").append(image2);
		sb.append(", image2_title=").append(image2_title);
		sb.append(", image3=").append(image3);
		sb.append(", image3_title=").append(image3_title);
		sb.append(", image4=").append(image4);
		sb.append(", image4_title=").append(image4_title);
		sb.append(", image5=").append(image5);
		sb.append(", image5_title=").append(image5_title);
		sb.append(", video=").append(video);
		sb.append(", video_title=").append(video_title);
		sb.append(", video2=").append(video2);
		sb.append(", video2_title=").append(video2_title);
		sb.append(", video3=").append(video3);
		sb.append(", video3_title=").append(video3_title);
		sb.append(", video4=").append(video4);
		sb.append(", video4_title=").append(video4_title);
		sb.append(", video5=").append(video5);
		sb.append(", video5_title=").append(video5_title);
		sb.append(", province=").append(province);
		sb.append(", city=").append(city);
		sb.append(", area=").append(area);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}

