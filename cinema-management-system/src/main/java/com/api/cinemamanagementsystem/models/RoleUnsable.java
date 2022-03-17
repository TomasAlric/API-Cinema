package com.api.cinemamanagementsystem.models;

public enum RoleUnsable {

    ADMIN(1), STANDARD(2);

    private int value;

    RoleUnsable(int value) {
        this.value = value;
    }
}
