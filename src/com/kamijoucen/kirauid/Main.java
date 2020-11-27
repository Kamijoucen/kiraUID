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
        bitsConfig1.addPart(BitsProperties.TIME);
        bitsConfig1.addPart(BitsProperties.CUSTOM, 5);
        bitsConfig1.addPart(BitsProperties.CUSTOM, 5);
        bitsConfig1.addPart(BitsProperties.SEQUENCE);
//        bitsConfig1.setTwepoch(1420041600000L);

        BitsAllocator allocator = new BitsAllocator(bitsConfig1);

        UidGenerator generator = new DefaultIdGenerator(allocator);

        for (int i = 0; i < 1000; i++) {
            System.out.println(generator.nextId(1, 2));
        }

    }
}
