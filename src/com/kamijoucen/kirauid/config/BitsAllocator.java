package com.kamijoucen.kirauid.config;


import com.kamijoucen.kirauid.domain.BitPart;

import java.util.List;

public class BitsAllocator {

    private BitsConfig bitsConfig;

    private BitPart[] bitParts;

    public BitsAllocator(BitsConfig bitsConfig) {
        this.bitsConfig = bitsConfig;
        bitParts = new BitPart[bitsConfig.getParts().size()];
        bitsConfig.getParts().toArray(bitParts);
    }

    public long allocate() {
        long data = 0;
        for (BitPart part : bitParts) {
            data |= part.getData() << part.getBitShift();
        }

//        return data ^ (1L << 63);
        return data;
    }

    public BitPart[] getBitParts() {
        return bitParts;
    }

    public BitsConfig getBitsConfig() {
        return bitsConfig;
    }
}
