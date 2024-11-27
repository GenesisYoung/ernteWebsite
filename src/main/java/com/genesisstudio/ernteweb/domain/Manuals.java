package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "manuals")
public class Manuals {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "title")
    private String title;

    /**
     * 文件地址
     */
    @TableField(value = "url")
    private String url;
}