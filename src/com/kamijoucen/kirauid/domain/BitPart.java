package com.kamijoucen.kirauid.domain;

import com.kamijoucen.kirauid.config.BitsProperties;

public class BitPart {

    private BitsProperties bitsProperties;
    /**
     * 二进制段长度
     */
    private long bits;

    /**
     * 最大支持数字
     */
    private long maxBit;

    /**
     * 左移位数
     */
    private long bitShift;

    public BitPart(long length, long baseBits, BitsProperties properties) {
        this.bits = length;
        this.maxBit = ~(-1 << length);
        this.bitShift = length + baseBits;
        this.bitsProperties = properties;
    }

    public long getBits() {
        return bits;
    }

    public long getMaxBit() {
        return maxBit;
    }

    public long getBitShift() {
        return bitShift;
    }
}