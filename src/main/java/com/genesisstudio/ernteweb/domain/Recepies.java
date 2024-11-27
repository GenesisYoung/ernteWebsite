package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "recepies")
public class Recepies {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 食谱名称
     */
    @TableField(value = "title")
    private String title;

    @TableField(value = "url")
    private String url;
}