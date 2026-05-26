package com.eduhub.eduhub_backend.Component;

import org.springframework.stereotype.Component;

@Component
public class Company {
    String name = "Rathish@co";
    public String getcompany(){
        return "company name"+ name;
    }
}
