package br.com;

public class RAM implements Memory {
    private final int[] data;
    private int size = 0;

    public RAM(int size) {
        this.size = size;
        this.data = new int[size];
    }

    @Override
    public int Read(int address) throws InvalidAddressException {
        VerifyAddress(address);
        return data[address];
    }

    @Override
    public void Write(int address, int value) throws InvalidAddressException {
        VerifyAddress(address);
        data[address] = value;
    }

    @Override
    public void VerifyAddress(int address) throws InvalidAddressException {
        if (address < 0 || address > size) {
            throw new InvalidAddressException(address);
        }
    }
}
