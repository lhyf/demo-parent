package org.lhyf.demo.model.Bo;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/****
 * @author YF
 * @date 2018-06-12 18:39
 * @desc RestResponseBo
 *
 **/

@Getter
@Setter
public class RestResponseBo<T> {

    /**
     * 服务器响应数据
     */
    private T payload;

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 状态码
     */
    private int code = -1;

    /**
     * 服务器响应时间
     */
    private long timestamp;

}
