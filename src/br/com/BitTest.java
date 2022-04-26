package br.com;

public class BitTest {
    public static void main(String[] args) {
        int x = 0b101010101010101010101010;
        int t = x >> 13;
        int r = t >>> 4;
        int s = (t << 7) | r;
        int w = x >> 18;

        System.out.println("x -> " + Integer.toBinaryString(x));
        System.out.println("t -> " + Integer.toBinaryString(t));
        System.out.println("r -> " + Integer.toBinaryString(r));
        System.out.println("s -> " + Integer.toBinaryString(s));
        System.out.println("w -> " + Integer.toBinaryString(w));
    }
}
