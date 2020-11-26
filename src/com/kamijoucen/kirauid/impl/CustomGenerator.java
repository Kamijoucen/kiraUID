package com.kamijoucen.kirauid.impl;

import com.kamijoucen.kirauid.PartGenerator;
import com.kamijoucen.kirauid.UidGenerator;
import com.kamijoucen.kirauid.domain.BitPart;

public class CustomGenerator implements PartGenerator {
    @Override
    public void generator(BitPart part, PartGenAdapter generator) {
        part.setData(generator.currentCustomData[part.getCustomIndex()]);
    }
}
