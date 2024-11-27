package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "hornor")
public class Hornor {
    /**
     * 荣誉ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 荣誉
     */
    @TableField(value = "hornor")
    private String hornor;
}