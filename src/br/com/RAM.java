package br.com;

public class RAM implements Memory {

    private final int size;
    private final int[] data;

    public RAM(int size) {
        this.size = size;
        this.data = new int[size];
    }

    @Override
    public int Read(int address) throws InvalidAddressException {
        VerifyAddress(address);
        return this.data[address];
    }

    @Override
    public void Write(int address, int value) throws InvalidAddressException {
        VerifyAddress(address);
        this.data[address] = value;
    }

    @Override
    public void VerifyAddress(int address) throws InvalidAddressException {
        if (address < 0 || address > this.size) {
            throw new InvalidAddressException(address);
        }
    }
}
