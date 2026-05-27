package com.eduhub.eduhub_backend.Exception;


public class SourceNotFound extends RuntimeException {
    public SourceNotFound(String resource,String field,String error){
        super(String.format("%s not found with %s.%s", resource,field,error));
    }
}
