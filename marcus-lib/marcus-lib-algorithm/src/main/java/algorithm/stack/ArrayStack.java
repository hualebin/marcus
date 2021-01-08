package algorithm.stack;

/**
 * 基于数组实现的顺序栈
 *
 */
public class ArrayStack {
    private int size; // 栈的大小
    private String[] items; // 数组
    private int count; //栈中的元素个数

    public ArrayStack(int size) {
        this.items = new String[size];
        this.size = size;
        this.count = 0;
    }

    // 入栈
    public boolean push(String item) {
        if (count == size) {
            return false;
        }
        items[count++] = item;
        return true;
    }

    // 出栈
    public String pop() {
        if (count == 0) {
            return null;
        }
        return items[--count];
    }
}
