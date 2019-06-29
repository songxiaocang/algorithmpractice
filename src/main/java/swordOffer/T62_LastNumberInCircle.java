package swordOffer;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 2:10 2019/6/30
 * @Description: 圆圈中最后剩下的数字（0~n-1, m）
 *  思路:
 *   有两种解法：循环链表和约瑟夫环 ,前者时间复杂度为0(mn)，后者时间复杂度为o(n)
 */
public class T62_LastNumberInCircle {
    public static int lastNumberInCircle(int n, int m){
        if (n<=0 || m<=0 ){
            return -1;
        }
        ListNode<Integer> head = new ListNode<>(0);
        ListNode<Integer> cur = head;
        for (int i=1;i<n;i++){
            ListNode<Integer> node = new ListNode<>(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;
        cur = head;
        while(true){
            if (cur.next == cur){
                return cur.val;
            }
            int i=1;
            while(i<m){
                cur = cur.next;
                i++;
            }
            cur.val =cur.next.val;
            cur.next = cur.next.next;
        }
    }

    //约瑟夫环，求证数学公式比较麻烦，暂不贴出
    public static int lastNumberInCircle2(int n, int m){
        if (n<=0 || m<=0){
            return -1;
        }
        int last = 0;
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(lastNumberInCircle(5,3));
        System.out.println(lastNumberInCircle(6,7));
        System.out.println(lastNumberInCircle(0,7));
        System.out.println(lastNumberInCircle2(5,3));
        System.out.println(lastNumberInCircle2(6,7));
        System.out.println(lastNumberInCircle2(0,7));
    }
}
