package com.kamijoucen.kirauid.impl;

import com.kamijoucen.kirauid.UidGenerator;
import com.kamijoucen.kirauid.config.BitsAllocator;
import com.kamijoucen.kirauid.domain.BitPart;

import java.util.List;

public class DefaultIdGenerator implements UidGenerator {

    private BitsAllocator allocator;

    private long lastTimestamp = -1L;

    private long sequence = 0L;

    public DefaultIdGenerator(BitsAllocator allocator) {
        this.allocator = allocator;
    }

    @Override
    public synchronized long nextId(long... args) {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException();
        }


        List<BitPart> bitParts = allocator.getBitParts();

        return 0;
    }

    @Override
    public long[] parseId() {
        return null;
    }


    private long timeGen() {
        return System.currentTimeMillis();
    }

    private long tilNextMillis(long lastTimestamp) {
        long time = timeGen();
        while (time <= lastTimestamp) {
            time = timeGen();
        }
        return time;
    }

}
