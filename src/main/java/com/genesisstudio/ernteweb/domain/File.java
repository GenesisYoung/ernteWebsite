package com.genesisstudio.ernteweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 文件表
 */
@Data
@TableName(value = "`file`")
public class File {
    /**
     * 文件ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 文件名
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 文件后缀名
     */
    @TableField(value = "ext")
    private String ext;

    /**
     * 文件
     */
    @TableField(value = "`file`")
    private byte[] file;
}