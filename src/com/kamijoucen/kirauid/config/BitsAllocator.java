package com.kamijoucen.kirauid.config;

import com.kamijoucen.kirauid.domain.BitPart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 需要
 */
public class BitsAllocator {

    private Map<BitsProperties, Long> defaultBits = new HashMap<BitsProperties, Long>();
    private List<BitPart> bitParts = new ArrayList<BitPart>();

    public BitsAllocator(BitsConfig bitsConfig) {

    }


}
