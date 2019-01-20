package com.lalit.library.subscriptionservice.model;

public enum Status {
    PENDING("P"),COMPLETE("C");

    private final String status;

    Status(String c) {
        this.status = c;
    }

    public String getStatus() {
        return status;
    }

    public static Status from(String statusCode){
        switch (statusCode){
            case "P" : return PENDING ;
            case "C" : return COMPLETE ;
            default: throw new IllegalArgumentException("Illegal Status Code");
        }
    }
}
