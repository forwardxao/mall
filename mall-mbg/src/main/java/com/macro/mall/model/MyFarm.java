package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MyFarm implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "农场名")
    private String farmName;

    @ApiModelProperty(value = "农场主名称")
    private String name;

    @ApiModelProperty(value = "具体地址")
    private String address;

    @ApiModelProperty(value = "图一")
    private String image;

    private String imageTitle;

    private String image2;

    private String image2Title;

    private String image3;

    private String image3Title;

    private String image4;

    private String image4Title;

    private String image5;

    private String image5Title;

    @ApiModelProperty(value = "视频一")
    private String video;

    private String videoTitle;

    private String video2;

    private String video2Title;

    private String video3;

    private String video3Title;

    private String video4;

    private String video4Title;

    private String video5;

    private String video5Title;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "世")
    private String city;

    @ApiModelProperty(value = "区/县")
    private String area;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage2Title() {
        return image2Title;
    }

    public void setImage2Title(String image2Title) {
        this.image2Title = image2Title;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage3Title() {
        return image3Title;
    }

    public void setImage3Title(String image3Title) {
        this.image3Title = image3Title;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage4Title() {
        return image4Title;
    }

    public void setImage4Title(String image4Title) {
        this.image4Title = image4Title;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getImage5Title() {
        return image5Title;
    }

    public void setImage5Title(String image5Title) {
        this.image5Title = image5Title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideo2() {
        return video2;
    }

    public void setVideo2(String video2) {
        this.video2 = video2;
    }

    public String getVideo2Title() {
        return video2Title;
    }

    public void setVideo2Title(String video2Title) {
        this.video2Title = video2Title;
    }

    public String getVideo3() {
        return video3;
    }

    public void setVideo3(String video3) {
        this.video3 = video3;
    }

    public String getVideo3Title() {
        return video3Title;
    }

    public void setVideo3Title(String video3Title) {
        this.video3Title = video3Title;
    }

    public String getVideo4() {
        return video4;
    }

    public void setVideo4(String video4) {
        this.video4 = video4;
    }

    public String getVideo4Title() {
        return video4Title;
    }

    public void setVideo4Title(String video4Title) {
        this.video4Title = video4Title;
    }

    public String getVideo5() {
        return video5;
    }

    public void setVideo5(String video5) {
        this.video5 = video5;
    }

    public String getVideo5Title() {
        return video5Title;
    }

    public void setVideo5Title(String video5Title) {
        this.video5Title = video5Title;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", farmName=").append(farmName);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", image=").append(image);
        sb.append(", imageTitle=").append(imageTitle);
        sb.append(", image2=").append(image2);
        sb.append(", image2Title=").append(image2Title);
        sb.append(", image3=").append(image3);
        sb.append(", image3Title=").append(image3Title);
        sb.append(", image4=").append(image4);
        sb.append(", image4Title=").append(image4Title);
        sb.append(", image5=").append(image5);
        sb.append(", image5Title=").append(image5Title);
        sb.append(", video=").append(video);
        sb.append(", videoTitle=").append(videoTitle);
        sb.append(", video2=").append(video2);
        sb.append(", video2Title=").append(video2Title);
        sb.append(", video3=").append(video3);
        sb.append(", video3Title=").append(video3Title);
        sb.append(", video4=").append(video4);
        sb.append(", video4Title=").append(video4Title);
        sb.append(", video5=").append(video5);
        sb.append(", video5Title=").append(video5Title);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}