package com.kamijoucen.kirauid.impl;

import com.kamijoucen.kirauid.PartGenerator;
import com.kamijoucen.kirauid.domain.BitPart;
import com.kamijoucen.kirauid.util.Utils;

public class SequenceGenerator implements PartGenerator {
    @Override
    public void generator(BitPart part, PartGenAdapter generator) {
        if (generator.currentTimestamp == generator.lastTimestamp) {
            generator.sequence = (generator.sequence + 1) & part.getMaxBit();
            if (generator.sequence == 0) {
                generator.currentTimestamp = Utils.tilNextMillis(generator.lastTimestamp);
            }
        } else {
            generator.sequence = 0;
        }
        generator.lastTimestamp = generator.currentTimestamp;
        part.setData(generator.sequence);
    }
}