package com.yx.yuojcodesandbox.model;

import lombok.Data;


/**
 * 进程执行信息
 */
@Data
public class ExecuteMessage {

    /**
     * 退出值
     */
    private Integer exitValue;

    /**
     * 正常输出信息
     */
    private String message;

    /**
     * 错误输出信息
     */
    private String errorMessage;

    /**
     * 运行时间
     */
    private Long time;

    /**
     * 运行内存
     */
    private Long memory;


}
