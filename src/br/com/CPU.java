package br.com;

public class CPU {
    private int PC = 0;
    private int regA = 0;
    private int regB = 0;
    private int regC = 0;

    private final Cache cache;
    private final IO io;

    public CPU(Cache cache, IO io) {
        this.cache = cache;
        this.io = io;
    }

    public void Run(int address) throws InvalidAddressException {
        PC = address;

        regA = cache.Read(PC++);
        regB = cache.Read(address + 800);

        regC = 15;

//        while (regA <= regB) {
//            cache.Write(regA, regC);
//            io.Output("> " + regA + " -> " + regC);
//
//            ++regC;
//            ++regA;
//        }

        cache.Write(0b00000001001_0000010_010000, 13);
        System.out.println(cache.Read(0b00000001001_0000010_010000));

        cache.Write(0b00000001011_0000011_010000, 124);
        System.out.println(cache.Read(0b00000001001_0000010_010000));
    }
}
