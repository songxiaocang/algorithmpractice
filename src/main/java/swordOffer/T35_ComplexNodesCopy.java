package swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Songxc
 * @Date: 22:31 2019/5/29
 * @Description:  复杂链表的复制
 *  思路：
 *   有三种方法
 *    1）先复制val和next域，在从头逐个复制sibling域
 *    2）先复制val和next域，并保存复制节点与原节点的对应关系到哈希表中，然后从哈希表中复制sibling节点到新节点上，通过提升空间复杂度降低时间复杂度
 *    3）先复制val和next域到新节点，并将新节点追加到原节点后面，然后复制sibling域，最后奇偶拆分链表，偶数节点组成的链表是复制链表
 *
 *    解法1 时间复杂度  空间复杂度
 *     1      0(N2)      0(1)
 *     2      0(N)       0(N)
 *     3      0(N)       0(1)
 *
 *    以下仅贴出解法2和3
 */
public class T35_ComplexNodesCopy {

    //解法2
    public static ComplexNode<Integer> clone1(ComplexNode<Integer> head){
        ComplexNode<Integer> newHead = new ComplexNode<>(head.val);
        newHead.next = head.next;
        ComplexNode<Integer> cur = head;
        ComplexNode<Integer> newCur = newHead;
        Map<ComplexNode<Integer>, ComplexNode<Integer>> map = new HashMap<>();
        while(cur != null){
            newCur = new ComplexNode<Integer>(cur.val);
            newCur.next = cur.next;
            map.put(cur, newCur);
            cur = cur.next;
        }

        cur = head;
        newCur = newHead;
        while(cur != null){
            if(cur.sibling != null){
                newCur.sibling = map.get(cur.sibling);
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }

    //解法3
    public static ComplexNode<Integer> clone2(ComplexNode<Integer> head){
        cloneNode(head);
        cloneSiblingNode(head);
        return reconnectNode(head);
    }

    public static void cloneNode(ComplexNode<Integer> head){
        ComplexNode<Integer> cur = head;
        ComplexNode<Integer> temp = null;
        while(cur != null){
            temp = new ComplexNode<Integer>(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
    }

    public static void cloneSiblingNode(ComplexNode<Integer> head){
        ComplexNode<Integer> cur = head;
        ComplexNode<Integer> newCur = head.next;
        while(cur!=null){
            if(cur.sibling != null){
                newCur.sibling = cur.sibling.next;
            }
            cur = cur.next.next;
            if(cur == null){
                break;
            }
            newCur = newCur.next.next;
        }
    }

    public static ComplexNode<Integer> reconnectNode(ComplexNode<Integer> head){
        ComplexNode<Integer> newHead = head.next;
        ComplexNode<Integer> cur = head;
        ComplexNode<Integer> newCur = newHead;
        while(cur!=null){
            cur.next = cur.next.next;
            cur = cur.next;
            if(cur == null){
                newCur.next = null;
                break;
            }
            newCur.next = newCur.next.next;
            newCur = newCur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ComplexNode<Integer> head = new ComplexNode(1);
        ComplexNode<Integer> c2 = new ComplexNode(2);
        ComplexNode<Integer> c3 = new ComplexNode(3);
        ComplexNode<Integer> c4 = new ComplexNode(4);
        ComplexNode<Integer> c5 = new ComplexNode(5);
        head.next = c2;
        head.sibling = c3;
        head.next.next = c3;
        head.next.sibling = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.sibling = c2;
        System.out.println("origin:"+head);
        System.out.println("new:   "+ clone2(head));
        System.out.println("new:   "+ clone1(head));
    }
}



class ComplexNode<T>{
    public T val;
    public ComplexNode<T> next;
    public ComplexNode<T> sibling;

    public ComplexNode(T val){
        this.val = val;
    }

    @Override
    public String toString(){
        ComplexNode<T> cur = this;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(cur != null){
            sb.append(cur.val);
            if(cur.sibling != null){
                sb.append("("+cur.sibling.val+") ");
            }else{
                sb.append("(_) ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
