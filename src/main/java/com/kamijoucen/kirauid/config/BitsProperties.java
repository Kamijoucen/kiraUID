package com.kamijoucen.kirauid.config;

public enum BitsProperties {

    TIME(0),
    SEQUENCE(1),
    CUSTOM(2),
    ;

    public int index;

    BitsProperties(int index) {
        this.index = index;
    }
}
