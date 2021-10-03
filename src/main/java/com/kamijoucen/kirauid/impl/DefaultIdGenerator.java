package com.kamijoucen.kirauid.impl;

import com.kamijoucen.kirauid.PartGenerator;
import com.kamijoucen.kirauid.UidGenerator;
import com.kamijoucen.kirauid.config.BitsAllocator;
import com.kamijoucen.kirauid.config.BitsConfig;
import com.kamijoucen.kirauid.config.BitsProperties;
import com.kamijoucen.kirauid.domain.BitPart;
import com.kamijoucen.kirauid.util.Utils;


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
        BitPart[] bitParts = allocator.getBitParts();
        for (BitPart bitPart : bitParts) {
            generators[bitPart.getBitsProperties().index].generator(bitPart, this);
        }
        return allocator.allocate();
    }

    @Override
    public long[] parseId(long id) {
        BitPart[] parts = this.allocator.getBitParts();
        long[] data = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            BitPart part = parts[i];
            data[i] = (id >>> part.getBitShift()) & part.getMaxBit();
        }
        return data;
    }

    @Override
    public boolean checkParam(long... args) {
        BitPart[] parts = allocator.getBitParts();
        for (BitPart part : parts) {
            if (part.getBitsProperties() == BitsProperties.CUSTOM
                    && check(part, args)) {
                return false;
            }
        }
        return true;
    }

    public boolean check(BitPart part, long... args) {
        return (part.getCustomIndex() >= args.length)
                || (part.getMaxBit() < args[part.getCustomIndex()]);
    }

    public static UidGenerator createDefaultGenerator() {
        return new DefaultIdGenerator(new BitsAllocator(BitsConfig.defaultConfig()));
    }

}
