package com.eagle.commons.exception;

public class ServiceException extends Exception {

    public static final int PROCESSING_FAILED = 1;
    public static final int VALIDATION_FAILED = 2;
    public static final int VALUE_DUPLICATION = 3;
    public static final int VALUE_NULL = 4;
    public static final int CUSTOM_ERROR = 5;


    private int code;

    private String[] messageArgs;

    public ServiceException() {
        super();
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(int code, String message, String[] messageArgs) {
        super(message);
        this.code = code;
        this.messageArgs = messageArgs;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Throwable cause, String[] messageArgs) {
        super(message, cause);
        this.messageArgs = messageArgs;
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(int code, String message, Throwable cause, String[] messageArgs) {
        super(message, cause);
        this.code = code;
        this.messageArgs = messageArgs;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String[] getMessageArgs() {
        return messageArgs;
    }

    public void setMessageArgs(String[] messageArgs) {
        this.messageArgs = messageArgs;
    }
}