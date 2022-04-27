package br.com;

public class Cache implements Memory {
    private final RAM ram;
    private int[][] data;
    private int wAddress;

    private int rAddress;

    private int tAddress;

    private int sAddress;

    private final Block block;

    public Cache(RAM ram) {
        this.data = new int[128][64];
        this.ram = ram;
        this.block = ram.getBlocks().get(tAddress);
    }

    public void setBitWiseOperations(int address) {
        sAddress = address >> 6;
        wAddress = (int) (address % Math.pow(2 ,6));
        tAddress = address >> 13;
        rAddress = (int) ((address >> 6) % Math.pow(2, 7));
    }

    @Override
    public int Read(int address) throws InvalidAddressException {
        if (VerifyAddress(address)) {
            setBitWiseOperations(address);
        } else {
            setBitWiseOperations(address);
        }

        return data[rAddress][wAddress];
    }

    @Override
    public void Write(int address, int value) {
        if (VerifyAddress(address)) {
            System.out.println("Cache miss on address: " + Integer.toBinaryString(address));
            data[rAddress][wAddress] = value;
        } else {
            System.out.println("Cache hit on address: " + Integer.toBinaryString(address));
            data[rAddress][wAddress] = value;
        }
    }

    @Override
    public boolean VerifyAddress(int address) {
        int tCPU = address >> 13;

        if (tCPU != tAddress) {
            System.out.println("Cache miss on address: " + Integer.toBinaryString(address));
            changeCache(address);

            return true;
        }

        return false;
    }

    private void changeCache(int address) {
        ram.getBlocks().get(tAddress).setData(data);
        setBitWiseOperations(address);

        if (block.getTag() != tAddress) {
            data = ram.getBlocks().get(tAddress).getData();
        }
    }
}
