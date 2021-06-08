package code.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);

        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode rest = addTwoNumbers(l1, l2);
        System.out.printf("rest :" + rest.toString());
    }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = 0, i = 0;
            while (l1 != null) {
                int node = l1.val * pow(10, i);
                sum += node;
                i++;
                l1 = l1.next;
            }

            int sum2 = 0, j = 0;
            while (l2 != null) {
                int node = l2.val * pow(10, j);
                sum2 += node;
                j++;
                l2 = l2.next;
            }
            int result = sum + sum2;

            String resultStr = result + "";


            System.out.println("sum : " + resultStr);
            char[] chars = resultStr.toCharArray();

            /*while (len > 0) {
                int s = result / pow(10, len - 1);
                result = result - s * pow(10, len - 1);
                arr[len - 1] = s;
                len--;
            }*/
            ListNode node = new ListNode(chars[chars.length-1]-'0');

            ListNode tmp = node;

            for (int k = 1; k < chars.length; k++) {
                tmp.next = new ListNode(chars[chars.length-1-k]-'0');
                tmp = tmp.next;
            }
            return node;
        }

        public static int pow(int m, int n) {
            int result = 1;
            for (int i = 0; i < n; i++) {
                result *= m;
            }
            return result;
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

