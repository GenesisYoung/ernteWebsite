package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品详情页图片关联表
 */
@Data
@TableName(value = "big_images")
public class BigImages {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 图片ID
     */
    @TableField(value = "img_id")
    private String imgId;

    /**
     * 产品ID
     */
    @TableField(value = "product_id")
    private Integer productId;
}