package com.xf.cloud.cloudsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author xf
 * @date 2021-04-07
 */
@Data
@TableName("sys_user")
public class User {

    @TableId
    private Long id;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

}
