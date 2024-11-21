package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品
 */
@Data
@TableName(value = "products")
public class Products {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "product")
    private String product;
}