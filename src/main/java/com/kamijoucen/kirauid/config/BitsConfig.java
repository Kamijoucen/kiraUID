package com.kamijoucen.kirauid.config;

import com.kamijoucen.kirauid.domain.BitPart;
import com.kamijoucen.kirauid.impl.CustomGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitsConfig {

    private Map<BitsProperties, Long> defaultBits = new HashMap<BitsProperties, Long>();
    private List<BitPart> parts = new ArrayList<BitPart>();
    private long twepoch = 0;
    int customIndex = -1;

    private long bits = 0;

    public BitsConfig() {
        defaultBits.put(BitsProperties.TIME, 41L);
        defaultBits.put(BitsProperties.SEQUENCE, 12L);
        defaultBits.put(BitsProperties.CUSTOM, 10L);
    }

    public void addPart(BitsProperties prop) {
        addPart(prop, defaultBits.get(prop));
    }

    public void addPart(BitsProperties prop, long length) {
        if ((length + bits) > 63) {
            throw new RuntimeException("too long!!!");
        }
        bits += length;
        BitPart part = new BitPart(length, 63 - bits, prop);
        if (prop == BitsProperties.CUSTOM) {
            part.setCustomIndex(++customIndex);
        }
        parts.add(part);
    }

    public static BitsConfig defaultConfig() {
        BitsConfig config = new BitsConfig();
        config.addPart(BitsProperties.TIME);
        config.addPart(BitsProperties.CUSTOM);
        config.addPart(BitsProperties.SEQUENCE);
        return config;
    }

    public List<BitPart> getParts() {
        return parts;
    }

    public long getTwepoch() {
        return twepoch;
    }

    public void setTwepoch(long twepoch) {
        this.twepoch = twepoch;
    }
}
