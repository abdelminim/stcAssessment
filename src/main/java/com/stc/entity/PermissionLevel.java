package com.stc.entity;

public enum PermissionLevel {
    READ("read"), WRITE("write"), DELETE("delete"), ADD("add");
    private String operation;

    PermissionLevel(String operation) {
        this.operation = operation;
    }

}
