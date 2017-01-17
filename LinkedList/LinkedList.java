package Test;

/**
 * 包含了各种链表题目
 * 主要取自 Leetcode
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedList {

    /**
     * Leetcode 24 https://leetcode.com/problems/swap-nodes-in-pairs/
     * 主要在于交换节点 1->2->3->4  交换后变为 2->1->4->3
     * 要考虑奇数和 null 等情况
     * 用递归的方法来处理
     *
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode root = head.next;
        head.next = swapPairs1(head.next.next);
        root.next = head;
        return root;
    }

    /**
     * Leetcode 24 https://leetcode.com/problems/swap-nodes-in-pairs/
     * 用迭代方法来处理
     * 在前面加上一个假头部，可以方便处理最开始的情况
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            // 如果没有下面这一行的话，计算结果为 1->3 下面这一行的作用是和之前的 current(对
            // 第一个来说也是 dummy) 保持联系
            current.next = second;
            second.next = first;
            current = second.next;
        }
        return dummy.next;
    }

    // -------------------------------------------------------------------------------------------

    /**
     * Leetcode 237:https://leetcode.com/problems/delete-node-in-a-linked-list/
     * 删除所给定的节点,你只有那个节点的权限
     * 这道题如果是要得到该节点的上个节点，然后串接，是很难做到的
     * 所以转换思路，把这个节点变成下一个节点
     *
     * @param head
     */
    public void deleteNode(ListNode head) {
        // ListNode target = new ListNode(head.next.val);
        head.val = head.next.val;
        head.next = head.next.next;

    }

    // -------------------------------------------------------------------------------------------

    /**
     * 这道题一开始只给了一个说明，就是逆转链表
     * 各种 edge case 都需要自己想
     *
     * @param head
     * @return
     */
    public ListNode reverseLinkedList1(ListNode head) {

    }


    // -------------------------------------------------------------------------------------------
    public void showLinkedList(ListNode head) {
        if (head == null)
            throw new IllegalArgumentException("节点头为空");
        ListNode root = head;
        StringBuilder builder = new StringBuilder();
        while (root.next != null) {
            System.out.print(root.val + "——>");
            root = root.next;
        }
        System.out.println(root.val);
    }

    public static ListNode insertNode(ListNode first, int value) {
        ListNode second = new ListNode(value);
        first.next = second;
        return second;
    }

    public ListNode structLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        return head;
    }

    public static void main(String args[]) {
        // 构造一个 List


        LinkedList linkedList = new LinkedList();
        ListNode head1 = linkedList.structLinkedList();
        // 标准输出
        linkedList.showLinkedList(head1); // 1——>2——>3——>4

        ListNode head2 = linkedList.structLinkedList();
        // 测试交换节点 递归法 swapPairs1()
        linkedList.showLinkedList(linkedList.swapPairs1(head2)); // 2——>1——>4——>3

        // 测试交换节点，迭代法 swapPairs2()//
        ListNode head3 = linkedList.structLinkedList();
        linkedList.showLinkedList(linkedList.swapPairs2(head3)); // 2——>1——>4——>3
    }
}

