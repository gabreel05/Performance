package br.com;

public class Main {

    public static void main(String[] args) throws InvalidAddressException {
        RAM ram = new RAM(16_777_216, 8192);
        IO io = new IO(System.out);
        Cache cache = new Cache(ram);
        CPU cpu = new CPU(cache, io);
        cpu.Run(0b00000001000_0000011_000101);
    }
}
