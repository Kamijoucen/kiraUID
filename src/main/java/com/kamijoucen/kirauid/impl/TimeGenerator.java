package com.kamijoucen.kirauid.impl;

import com.kamijoucen.kirauid.PartGenerator;
import com.kamijoucen.kirauid.UidGenerator;
import com.kamijoucen.kirauid.config.BitsConfig;
import com.kamijoucen.kirauid.domain.BitPart;

public class TimeGenerator implements PartGenerator {

    @Override
    public void generator(BitPart part, PartGenAdapter generator) {
        BitsConfig bitsConfig = generator.allocator.getBitsConfig();
        part.setData(generator.currentTimestamp - bitsConfig.getTwepoch());
    }
}
