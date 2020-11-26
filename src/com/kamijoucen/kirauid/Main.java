package com.kamijoucen.kirauid;

import com.kamijoucen.kirauid.config.BitsAllocator;
import com.kamijoucen.kirauid.config.BitsConfig;
import com.kamijoucen.kirauid.config.BitsProperties;
import com.kamijoucen.kirauid.impl.DefaultIdGenerator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BitsConfig bitsConfig = BitsConfig.defaultConfig();
        BitsConfig bitsConfig1 = new BitsConfig();
        bitsConfig1.addPart(BitsProperties.TIME, 62);
        bitsConfig1.addPart(BitsProperties.SEQUENCE, 1);
        bitsConfig.setTwepoch(1420041600000L);

        BitsAllocator allocator = new BitsAllocator(bitsConfig1);

        DefaultIdGenerator generator = new DefaultIdGenerator(allocator);

        for (int i = 0; i < 1000; i++) {
            System.out.println(generator.nextId(1));
        }

    }
}
