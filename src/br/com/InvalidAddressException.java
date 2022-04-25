package br.com;

public class InvalidAddressException extends Exception {
    public final int address;

    public InvalidAddressException(int address) {
        super();
        this.address = address;
    }

    @Override
    public String toString() {
        return "Invalid Address: " + address;
    }
}
