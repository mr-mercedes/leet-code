package ru.borovikov;

import java.math.BigDecimal;

public class SolutionAddTwoNumbers {

    public static ListNode addTwoNumbersWithGptRecommended(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = v1 + v2 + carry;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    /*Хорошо читается но плохо работает*/
    public static ListNode addTwoNumbersMySolve(ListNode l1, ListNode l2) {
        String first = extractor(l1, new StringBuilder());
        String second = extractor(l2, new StringBuilder());
        BigDecimal result = new BigDecimal(first).add(new BigDecimal(second));
        String sum = String.valueOf(result);
        return inserter(new ListNode(), new StringBuilder(sum).reverse().toString());
    }

    public static ListNode addTwoNumbersTheBestSolve(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int count = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + count;
            if (sum >= 10) {
                count = 1;
                sum = sum % 10;
            } else {
                count = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        cur.next = count == 1 ? new ListNode(1) : null;
        return dummy.next;
    }

    private static String extractor(ListNode node, StringBuilder string) {
        if (node == null) return string.reverse().toString();
        string.append(node.val);
        return extractor(node.next, string);
    }

    private static ListNode inserter(ListNode node, String result) {
        node.val = Integer.parseInt(result.substring(0, 1));
        String next = result.substring(1);
        if (next.isEmpty()) return node;
        node.next = inserter(new ListNode(), result.substring(1));
        return node;
    }


    public static class ListNode {
        private int val;
        private ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
