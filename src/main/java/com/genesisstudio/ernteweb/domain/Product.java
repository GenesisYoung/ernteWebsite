package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品表
 */
@Data
@TableName(value = "product")
public class Product {
    /**
     * 产品id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 产品名称
     */
    @TableField(value = "title")
    private String title;

    /**
     * 产品详细页名称
     */
    @TableField(value = "detail_title")
    private String detailTitle;

    /**
     * 产品英文名
     */
    @TableField(value = "title_en")
    private String titleEn;

    /**
     * 详情页文章标题
     */
    @TableField(value = "article_title")
    private String articleTitle;

    /**
     * 颜色
     */
    @TableField(value = "color")
    private String color;

    /**
     * 图片ID
     */
    @TableField(value = "img_id")
    private String imgId;

    /**
     * 系列ID
     */
    @TableField(value = "series_id")
    private Integer seriesId;

    /**
     * 详情页左侧文章图片ID
     */
    @TableField(value = "left_img_id")
    private String leftImgId;

    /**
     * 详细页主题图片ID
     */
    @TableField(value = "detail_image_id")
    private String detailImageId;

    /**
     * 详情页文章
     */
    @TableField(value = "article")
    private String article;

    /**
     * 产品描述
     */
    @TableField(value = "description")
    private String description;

    @TableField(exist = false)
    private String series;

    @TableField(exist = false)
    private String path;
}