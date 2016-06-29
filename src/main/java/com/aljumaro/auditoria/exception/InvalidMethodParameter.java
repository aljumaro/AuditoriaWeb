package com.aljumaro.auditoria.exception;

/**
 * @Date 24/06/2016
 * @Time 18:28
 * @Author Juanma
 */
public class InvalidMethodParameter extends BaseException {

    private static final String MESSAGE_KEY = "exception.method.param";

    public InvalidMethodParameter(String message) {
        super(message, MESSAGE_KEY);
    }
}
