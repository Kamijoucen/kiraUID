package com.kamijoucen.kirauid.impl;

import com.kamijoucen.kirauid.PartGenerator;
import com.kamijoucen.kirauid.config.BitsAllocator;
import com.kamijoucen.kirauid.config.BitsProperties;
import com.kamijoucen.kirauid.domain.BitPart;
import com.kamijoucen.kirauid.util.Utils;

import java.util.List;

public class DefaultIdGenerator extends PartGenAdapter {


    public DefaultIdGenerator(BitsAllocator allocator) {
        this.allocator = allocator;
        generators = new PartGenerator[BitsProperties.values().length];
        generators[BitsProperties.TIME.index] = new TimeGenerator();
        generators[BitsProperties.SEQUENCE.index] = new SequenceGenerator();
        generators[BitsProperties.CUSTOM.index] = new CustomGenerator();
    }

    @Override
    public synchronized long nextId(long... args) {
        currentTimestamp = Utils.timeGen();
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException();
        }
        this.currentCustomData = args;
        List<BitPart> bitParts = allocator.getBitParts();
        for (BitPart bitPart : bitParts) {
            generators[bitPart.getBitsProperties().index].generator(bitPart, this);
        }
        return allocator.allocate();
    }

    @Override
    public long[] parseId() {
        return null;
    }

}
