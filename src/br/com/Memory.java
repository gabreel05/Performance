package br.com;

public interface Memory {
    int Read(int address) throws InvalidAddressException;
    void Write(int address, int value) throws InvalidAddressException;
    void VerifyAddress(int address) throws InvalidAddressException;
}
