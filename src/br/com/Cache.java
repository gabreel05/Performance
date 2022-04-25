package br.com;

public class Cache implements Memory {
    private final int size;
    private int[] data;
    private final RAM ram;

    public Cache(int size, RAM ram) {
        this.size = size;
        this.data = new int[size];
        this.ram = ram;
    }

    @Override
    public int Read(int address) throws InvalidAddressException {
        VerifyAddress(address);
        int ramAddress = ram.Read(address);

        for (int i = 0; i < size; i++) {
            if (data[i] == ramAddress) {
                return ramAddress;
            }
        }

        return -1;
    }

    @Override
    public void Write(int address, int value) throws InvalidAddressException {

    }

    @Override
    public void VerifyAddress(int address) throws InvalidAddressException {
        if (address < 0 || address > size) {
            throw new InvalidAddressException(address);
        }
    }
}
