package com.oyo.book.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class Greeting {

    private String msg;
    private String name;
    
    public Greeting(String msg) {
    	this.msg = msg;
    	this.name = "Default name";
    }

    public Greeting(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }
    
    public Greeting() {
    	
    }
}