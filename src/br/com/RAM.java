package br.com;

import java.util.ArrayList;
import java.util.List;

public class RAM implements Memory {

    private final int size;
    private final int[] data;
    private final int cacheSize;
    private final int blocksQuantity;
    private final List<Block> blocks;

    public RAM(int size, int cacheSize) {
        this.size = size;
        this.data = new int[size];
        this.cacheSize = cacheSize;
        this.blocksQuantity = size / cacheSize;
        blocks = new ArrayList<>(blocksQuantity);

        for (int j = 0; j < blocksQuantity; j++) {
            blocks.add(new Block(j));
        }
    }

    @Override
    public int Read(int address) throws InvalidAddressException {
        if (VerifyAddress(address)) {
            throw new InvalidAddressException(address);
        }
        return this.data[address];
    }

    @Override
    public void Write(int address, int value) throws InvalidAddressException {
        if (VerifyAddress(address)) {
            throw new InvalidAddressException(address);
        }
        this.data[address] = value;
    }

    @Override
    public boolean VerifyAddress(int address) {
        return address < 0 || address > this.size;
    }

    public int getSize() {
        return size;
    }

    public int[] getData() {
        return data;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public int getBlocksQuantity() {
        return blocksQuantity;
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
