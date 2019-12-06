package com.tx.common.exception;


import com.tx.common.sdk.enums.EnumCode;

public abstract class AccessException extends AppException {

    /**
     * 
     */
    private static final long serialVersionUID = -6534358261167093308L;

    public AccessException(EnumCode<String> code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public AccessException(EnumCode<String> code, String message) {
        super(code, message);
    }

    public AccessException(EnumCode<String> code, Throwable cause) {
        super(code, cause);
    }

    public AccessException(EnumCode<String> code) {
        super(code);
    }

}
