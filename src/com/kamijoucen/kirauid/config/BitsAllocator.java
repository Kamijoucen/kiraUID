package com.kamijoucen.kirauid.config;


import com.kamijoucen.kirauid.domain.BitPart;

import java.util.List;

public class BitsAllocator {

    private BitsConfig bitsConfig;

    public BitsAllocator(BitsConfig bitsConfig) {
        this.bitsConfig = bitsConfig;
    }

    public long allocate() {
        long data = 0;
        List<BitPart> parts = bitsConfig.getParts();
        for (BitPart part : parts) {
            data |= part.getData() << part.getBitShift();
        }

//        return data ^ (1L << 63);
        return data;
    }

    public List<BitPart> getBitParts() {
        return this.bitsConfig.getParts();
    }

    public BitsConfig getBitsConfig() {
        return bitsConfig;
    }
}
