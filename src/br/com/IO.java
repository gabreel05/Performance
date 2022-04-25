package br.com;

public class IO {
    final java.io.PrintStream output;

    public IO(java.io.PrintStream s) {
        output = s;
    }

    public void Output(String message) {
        output.println(message);
    }
}
