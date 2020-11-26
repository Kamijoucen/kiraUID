package com.kamijoucen.kirauid.config;


import com.kamijoucen.kirauid.domain.BitPart;

import java.util.List;

public class BitsAllocator {

    private BitsConfig bitsConfig;

    public BitsAllocator(BitsConfig bitsConfig) {
        this.bitsConfig = bitsConfig;
    }

    public long allocate(long time) {

        return 0;
    }

    public List<BitPart> getBitParts() {
        return this.bitsConfig.getParts();
    }

}
