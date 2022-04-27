package br.com;

public class Block {
    private int[][] data;
    private boolean flag;
    private int tag;

    public Block(int tag) {
        this.data = new int[128][64];
        this.flag = false;
        this.tag = tag;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
