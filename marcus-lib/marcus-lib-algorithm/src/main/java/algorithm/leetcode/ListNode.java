package algorithm.leetcode;

public class ListNode {
    ListNode next;
    int num;

    public ListNode() {
    }

    public ListNode(int num) {
        this.num = num;
    }

    public ListNode(ListNode next, int num) {
        this.next = next;
        this.num = num;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ListNode getNext() {
        return this.next;
    }

    public int getNum() {
        return this.num;
    }

    public boolean hasNext() {
        if (this.next == null) {
            return false;
        }
        return true;
    }
}
