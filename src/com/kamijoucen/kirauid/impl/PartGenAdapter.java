package com.kamijoucen.kirauid.impl;

import com.kamijoucen.kirauid.PartGenerator;
import com.kamijoucen.kirauid.UidGenerator;
import com.kamijoucen.kirauid.config.BitsAllocator;

public abstract class PartGenAdapter implements UidGenerator {

    PartGenerator[] generators = null;

    BitsAllocator allocator;

    long currentTimestamp = -1L;

    long lastTimestamp = -1L;

    long sequence = 0L;

    long[] currentCustomData = null;

}
