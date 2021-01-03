package cn.zwq.algorithm.simple;

/**
 *  21. 合并两个有序链表
 *
 *  因为两个链表的长度可能不一样，所以以最短长度的链表为循环停止条件
 *  采用新链表连接以前两个链表的节点，形成最终的一条有序链表
 *
 *  循环结束之后，可能会出现两个链表中的某一个还存在节点，
 *  但是剩余链表节点值绝对是比新链表的节点值要大，所以再用新链表的 next 指向剩余的链表即可
 *
 * @author G20200343200113
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeNode = new ListNode(0);
        ListNode tempNode = mergeNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = l1 == null ? l2 : l1;
        return mergeNode.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}