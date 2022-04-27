package br.com;

public class Block {
    int[][] data;
    boolean flag;
    int tag;

    public Block(int tag) {
        this.data = new int[128][64];
        this.flag = false;
        this.tag = tag;
    }
}
