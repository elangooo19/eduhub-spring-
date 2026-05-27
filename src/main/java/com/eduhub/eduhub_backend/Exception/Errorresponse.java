package com.eduhub.eduhub_backend.Exception;

import java.security.PrivateKey;
import java.time.LocalDateTime;

public class Errorresponse {
    private LocalDateTime timeStamp;
    private int Status;
    private  String Massage;
    private  String path;
    private String error;

    public Errorresponse(LocalDateTime timeStamp, int status, String massage, String path, String error) {
        this.timeStamp = timeStamp;
        Status = status;
        Massage = massage;
        this.path = path;
        this.error = error;
    }
}
