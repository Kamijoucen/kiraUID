package com.kamijoucen.kirauid.config;

public class BitsConfig {

    public final UidType type;

    public BitsConfig(UidType type) {
        this.type = type;
    }

    public void addPart(BitsProperties prop) {
    }

    public void addPart(BitsProperties prop, int length) {
    }

    public enum UidType {
        LONG,
        STRING
    }

}
