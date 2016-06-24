package com.aljumaro.auditoria.Exception;

/**
 * @Date 24/06/2016
 * @Time 18:27
 * @Author Juanma
 */
public class BaseException extends RuntimeException{

    private String message;
    private String messageKey;

    public BaseException(String message, String messageKey) {
        this.message = message;
        this.messageKey = messageKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
}
