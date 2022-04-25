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
        regB = cache.Read(PC++);

        regC = 1;

        while (regA <= regB) {
            cache.Write(regA, regC);
            io.Output("> " + regA + " -> " + regC);

            ++regC;
            ++regA;
        }
    }
}
