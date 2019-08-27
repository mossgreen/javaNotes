package com.example.demoenum;

public enum Season {
    SPRING("1"),
    SUMMER("2"),
    AUTUMN("3"),
    WINTER("4");

    private String code;

    Season(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
