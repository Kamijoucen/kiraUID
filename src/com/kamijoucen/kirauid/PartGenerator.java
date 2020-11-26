package com.kamijoucen.kirauid;

import com.kamijoucen.kirauid.domain.BitPart;
import com.kamijoucen.kirauid.impl.PartGenAdapter;

public interface PartGenerator {

    void generator(BitPart part, PartGenAdapter generator);

}
