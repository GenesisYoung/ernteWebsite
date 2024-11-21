package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 线下门店
 */
@Data
@TableName(value = "offline_spots")
public class OfflineSpots {
    /**
     * 城市ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 城市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 地点英文
     */
    @TableField(value = "en")
    private String en;

    /**
     * 门店地址
     */
    @TableField(value = "spots")
    private String spots;
}