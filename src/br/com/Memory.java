package br.com;

public interface Memory {
    public int Read(int address) throws InvalidAddressException;
    public void Write(int address, int value) throws InvalidAddressException;
    public void VerifyAddress(int address) throws InvalidAddressException;
}
