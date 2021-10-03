package com.kamijoucen.kirauid;

public interface UidGenerator {

    long nextId(long... args);

    long[] parseId(long id);

    boolean checkParam(long... args);

}
