package nil.ed.file.data.impl;

public enum WriteDataType {
    BYTE(1), CHAR(2), SHORT(2), INT(4), DOUBLE(8), LONG(8);
    private int size;

    private WriteDataType(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
