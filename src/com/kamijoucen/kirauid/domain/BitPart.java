package com.kamijoucen.kirauid.domain;

import com.kamijoucen.kirauid.config.BitsProperties;

public class BitPart {

    private BitsProperties bitsProperties;

    private int customIndex = -1;

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

    /**
     * 数据
     */
    private long data;

    public BitPart(long length, long baseBits, BitsProperties properties) {
        this.bits = length;
        this.maxBit = ~(-1L << length);
        this.bitShift = baseBits;
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

    public BitsProperties getBitsProperties() {
        return bitsProperties;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getCustomIndex() {
        return customIndex;
    }

    public void setCustomIndex(int customIndex) {
        this.customIndex = customIndex;
    }
}
