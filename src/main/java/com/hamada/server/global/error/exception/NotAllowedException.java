package com.hamada.server.global.error.exception;


import com.hamada.server.global.error.ErrorCode;

public class NotAllowedException extends BusinessException {

    public NotAllowedException() {
        super(ErrorCode.METHOD_NOT_ALLOWED);
    }

    public NotAllowedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
