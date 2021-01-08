package algorithm.leetcode;

public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        ListNode node = lists[0];
        for (int i = 1; i < k; i++) {
            ListNode next = lists[i];
            ListNode nNode = node;
            ListNode cNode = node;
            System.out.println("node:" +  node.num);
            while(cNode != null && next != null) {
                ListNode prevNode = null;
                System.out.println("cNode:" +  cNode.num);
                System.out.println("next:" +  next.num);
                if (cNode.num <= next.num) {
                    prevNode = cNode;
                    cNode = cNode.next;
                } else {
                    ListNode temp = next;
                    next = next.next;
                    if (prevNode == null) {
                        /*if (nNode == node) {
                            temp.next = nNode;
                            nNode = temp;
                        } else {
                            temp.next = nNode.next;
                            nNode.next = temp;
                        }*/
                        temp.next = node;
                        node = temp;
                    } else {
                        System.out.println("prevNode:" +  prevNode.num);
                        prevNode.next = temp;
                        temp.next = cNode;
                    }
                }
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode[] listNodes1 = new ListNode[3];
        ListNode listNode1 = new ListNode(1);
        listNode1.setNext(new ListNode(4));
        listNode1.next.setNext(new ListNode(5));
        listNodes1[0] = listNode1;

        ListNode listNode2 = new ListNode(1);
        listNode2.setNext(new ListNode(3));
        listNode2.next.setNext(new ListNode(4));
        listNodes1[1] = listNode2;

        ListNode listNode3 = new ListNode(2);
        listNode3.setNext(new ListNode(6));
        listNodes1[2] = listNode3;

        ListNode node = mergeKLists(listNodes1);
        System.out.print("[");
        while(node != null) {
            System.out.print(node.getNum() + ", ");
            node = node.next;
        }
        System.out.print("]");
    }
}
