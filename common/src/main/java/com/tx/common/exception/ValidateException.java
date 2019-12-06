package com.tx.common.exception;

import com.tx.common.sdk.enums.EnumCode;

/**
 * @author: T.X
 * @create: 2018-12-20 14:08
 **/
public class ValidateException extends AppException {

    private static final long serialVersionUID = 961794978717991823L;

    public ValidateException(EnumCode<String> code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public ValidateException(EnumCode<String> code, String message) {
        super(code, message);
    }

    public ValidateException(EnumCode<String> code, Throwable cause) {
        super(code, cause);
    }

    public ValidateException(EnumCode<String> code) {
        super(code);
    }
}
