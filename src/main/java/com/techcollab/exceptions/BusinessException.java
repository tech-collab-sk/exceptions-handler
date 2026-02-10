package com.techcollab.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends  RuntimeException {

	private static final long serialVersionUID = 2457189159617736175L;
	
	private final HttpStatus status;
    private String message;
    private String code;
    private ErrorCodes errorCode;
    private Object[] args;


    public BusinessException(final Throwable ex, final String message, final HttpStatus status) {
        super(message, ex);
        
        this.status = status;
        this.message = message;
        this.code = "ERROR0000";
    }
    

    public BusinessException(final Throwable ex, final String message, final String code, final HttpStatus status) {
        super(message, ex);
        this.status = status;
        this.message = message;
        this.code = null;
    }


    public BusinessException(final String message, final HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
        this.code = "ERROR0000";
        
    }
    
    public BusinessException(final ErrorCodes errorCode, final HttpStatus status) {
        super();
        this.status = status;
        this.errorCode = errorCode;
        this.message = errorCode.getName();
        this.code = errorCode.getValue();
    }
    
    
    public BusinessException(final ErrorCodes errorCode, Object[] args, final HttpStatus status) {
        super();
        this.status = status;
        this.errorCode = errorCode;
        this.message = errorCode.getName();
        this.code = errorCode.getValue();
        this.args = args;
    }

    public BusinessException(final String message, final String code, final HttpStatus status) {
    	super(message);
        this.status = status;
        this.message = message;
        this.code = code;
        
    }

    public BusinessException(final Throwable ex, final String message, final Integer status) {
        super(message, ex);
        final HttpStatus resolvedStatus = HttpStatus.resolve(status);
        this.status =  resolvedStatus == null ? HttpStatus.INTERNAL_SERVER_ERROR : resolvedStatus;
        this.message = message;
        this.code = "ERROR0000";
    }

    public BusinessException(final Throwable ex, final String message) {
        super(message, ex);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = message;
        this.code = "ERROR0000";
    }

    public BusinessException(final String message, final Integer status) {
        super(message);
        final HttpStatus resolvedStatus = HttpStatus.resolve(status);
        this.status =  resolvedStatus == null ? HttpStatus.INTERNAL_SERVER_ERROR : resolvedStatus;
        this.message = message;
        this.code = "ERROR0000";
    }

    public BusinessException(final Throwable ex) {
        super(ex);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = ex.getMessage();
        this.code = "ERROR0000";
    }


}
