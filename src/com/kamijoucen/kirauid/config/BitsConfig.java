package com.kamijoucen.kirauid.config;

import com.kamijoucen.kirauid.domain.BitPart;

import java.util.ArrayList;
import java.util.List;

public class BitsConfig {

    private int allBits = 0;

    private List<BitPart> parts = new ArrayList<BitPart>();

    public boolean addPart(BitsProperties prop) {

        return true;
    }

    public void addPart(BitsProperties prop, int length) {

    }

    public static BitsConfig defaultConfig() {
        BitsConfig config = new BitsConfig();
        config.addPart(BitsProperties.TIME);
        config.addPart(BitsProperties.WORKER);
        config.addPart(BitsProperties.SEQUENCE);
        return config;
    }

}
