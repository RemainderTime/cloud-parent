package com.xf.cloud.cloudsystem.model;

import lombok.Data;

/**
 * @program: cloud-parent
 * @description: 统一返回对象
 * @author: xf
 * @create: 2021-05-04 21:23
 **/
@Data
public class ResponseResult {

    public ResponseResult(Integer code) {
        this.code = code;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 状态
     */
    private Integer code;

    /**
     * 返回的数据对像
     */
    private Object data;

    /**
     * 返回的状态信息
     */
    private String msg;
}
