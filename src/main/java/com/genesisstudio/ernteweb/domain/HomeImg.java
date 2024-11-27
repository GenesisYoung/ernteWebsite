package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "home_img")
public class HomeImg {
    /**
     * 主页展示图
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 图片ID
     */
    @TableField(value = "img_id")
    private String imgId;
}