package com.kamijoucen.kirauid.impl;

import com.kamijoucen.kirauid.UidGenerator;
import com.kamijoucen.kirauid.config.BitsAllocator;

public class DefaultIdGenerator implements UidGenerator {

    private BitsAllocator allocator;

    public DefaultIdGenerator(BitsAllocator allocator) {
        this.allocator = allocator;
    }

    @Override
    public long nextId() {
        return 0;
    }

    @Override
    public long[] parseId() {
        return null;
    }
}
