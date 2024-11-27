package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品系列
 */
@Data
@TableName(value = "series")
public class Series {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 系列名称
     */
    @TableField(value = "series_name")
    private String seriesName;
}