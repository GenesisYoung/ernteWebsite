package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 事件
 */
@Data
@TableName(value = "events")
public class Events {
    /**
     * 事件ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 事件名
     */
    @TableField(value = "title")
    private String title;

    /**
     * 事件
     */
    @TableField(value = "`text`")
    private String text;
}