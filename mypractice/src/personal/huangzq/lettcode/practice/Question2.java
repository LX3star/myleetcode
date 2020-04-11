package personal.huangzq.lettcode.practice;

import java.math.BigDecimal;

/**
 * @ClassName Question2
 * @Description TODO 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 链接： https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @Author huangzq
 * @Mailbox 1375529585@qq.com
 * @Date 2020/4/11 11:57
 * @Version 1.0
 */
public class Question2 {

    // 内部基本类
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 自己的解题思路：
     *
     */
    public ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {


        String numA = getMes(l1, "");
        BigDecimal numAValue = new BigDecimal(numA);
        String numB = getMes(l2, "");
        BigDecimal numBValue = new BigDecimal(numB);
        String result = numAValue.add(numBValue).toString();
        System.out.println(result);
        int len = result.length();

        ListNode node = new ListNode(0);
        ListNode current = new ListNode(0);


        for (int i = len - 1; i >= 0; i--) {

            String temp = result.substring(i, i + 1);

            ListNode tempNode = new ListNode(Integer.valueOf(temp));
            if (i == len - 1) {
                node = tempNode;
                current = node.next == null ? new ListNode(0) : node.next;
            }

            current.next=tempNode;
            current = current.next == null ? new ListNode(0) : current.next;

        }

        return node;
    }

    public String getMes(ListNode node, String numStr) {

        String tempStr = String.valueOf(node.val);
        numStr = tempStr + numStr;
        ListNode tempNode = node.next;
        if (tempNode != null) {
            return getMes(tempNode, numStr);
        }
        return numStr;
    }

}
