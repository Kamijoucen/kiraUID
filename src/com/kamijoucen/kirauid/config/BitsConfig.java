package com.kamijoucen.kirauid.config;

import com.kamijoucen.kirauid.domain.BitPart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitsConfig {

    private Map<BitsProperties, Long> defaultBits = new HashMap<BitsProperties, Long>();
    private List<BitPart> parts = new ArrayList<BitPart>();

    private long bits = 0;

    public BitsConfig() {
        defaultBits.put(BitsProperties.TIME, 41L);
        defaultBits.put(BitsProperties.SEQUENCE, 12L);
    }

    public boolean addPart(BitsProperties prop) {
        return addPart(prop, defaultBits.get(prop));
    }

    public boolean addPart(BitsProperties prop, long length) {
        if (prop == BitsProperties.CUSTOM || (length + bits) > 63) {
            return false;
        }
        parts.add(new BitPart(length, bits, prop));
        bits += length;
        return true;
    }

    public boolean addCustomPart(long length) {

        return false;
    }

    public static BitsConfig defaultConfig() {
        BitsConfig config = new BitsConfig();
        config.addPart(BitsProperties.TIME);
        config.addPart(BitsProperties.SEQUENCE);
        return config;
    }

}
