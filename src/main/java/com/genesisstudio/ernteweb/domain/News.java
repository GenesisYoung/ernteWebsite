package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 新闻
 */
@Data
@TableName(value = "news")
public class News {
    /**
     * 新闻ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 新闻分类
     */
    @TableField(value = "category")
    private String category;

    /**
     * 新闻日期
     */
    @TableField(value = "`date`")
    private Date date;

    /**
     * 新闻标题
     */
    @TableField(value = "title")
    private String title;

    @TableField(value = "img_id")
    private String imgId;

    /**
     * 新闻描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 新闻内容
     */
    @TableField(value = "context")
    private String context;
}