package br.com;

import java.util.Arrays;

public class Cache implements Memory {
    private final RAM ram;
    private int[][] data;

    boolean flag;

    private int w;

    private int r;

    private int t;

    private int s;

    Block block;

    public Cache(RAM ram) {
        this.data = new int[128][64];
        this.ram = ram;
        this.block = ram.getBlocks().get(t);
    }

    public void setBitWiseOperations(int address) {
        s = address >> 6;
        w = (int) (address % Math.pow(2 ,6));
        t = address >> 13;
        r = (int) ((address >> 6) % Math.pow(2, 7));
    }

    @Override
    public int Read(int address) throws InvalidAddressException {
        if (VerifyAddress(address)) {
            System.out.println("Cache miss on address: " + Integer.toBinaryString(address));
        } else {
//            System.out.println("Cache hit on address: " + Integer.toBinaryString(address));
        }

        return data[r][w];
    }

    @Override
    public void Write(int address, int value) throws InvalidAddressException {
        if (VerifyAddress(address)) {
            System.out.println("Cache miss on address: " + Integer.toBinaryString(address));
            System.out.println("Estou escrevendo " + value + " em " + r + " " + w);
            data[r][w] = value;
        } else {
            System.out.println("Cache hit on address: " + Integer.toBinaryString(address));
            System.out.println("Estou escrevendo " + value + " em " + r + " " + w);
            data[r][w] = value;
        }
    }

    @Override
    public boolean VerifyAddress(int address) throws InvalidAddressException {
        int tCPU = address >> 13;

        System.out.println("Minha tag é" + t  + " e a tag da CPU é " + tCPU);

        if (tCPU != t) {
            System.out.println("Estou trocando de cache");
            changeCache(address);

            return true;
        }

        return false;
    }

    private void changeCache(int address) {
        setBitWiseOperations(address);

        if (block.tag != t) {

            Block ramBlock = ram.getBlocks().get(t);

//            System.out.println(Arrays.deepToString(ramBlock.data));

            ramBlock.data = data;
            data = block.data;

            ram.getBlocks().set(t, ramBlock);
//            System.out.println(Arrays.deepToString(ramBlock.data));
//            System.out.println(Arrays.deepToString(data));
        }

    }
}
