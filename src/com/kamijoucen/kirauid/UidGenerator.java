package com.kamijoucen.kirauid;

public interface UidGenerator {

    long nextId(long... args);

    long[] parseId();

}
