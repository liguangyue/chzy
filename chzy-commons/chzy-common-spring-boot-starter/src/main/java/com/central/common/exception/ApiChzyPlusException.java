package com.central.common.exception;

/**
 * 自定义异常
 *
 * @author zscat
 * @email 939961241@qq.com
 * @date 2016年10月27日 下午10:11:27
 */
public class ApiChzyPlusException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errmsg;
    private int errno = 500;

    public ApiChzyPlusException(String errmsg) {
        super(errmsg);
        this.errmsg = errmsg;
    }

    public ApiChzyPlusException(String errmsg, Throwable e) {
        super(errmsg, e);
        this.errmsg = errmsg;
    }

    public ApiChzyPlusException(String errmsg, int errno) {
        super(errmsg);
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public ApiChzyPlusException(String errmsg, int errno, Throwable e) {
        super(errmsg, e);
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }
}
