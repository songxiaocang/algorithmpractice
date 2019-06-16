package util;

/**
 * @Author: Songxc
 * @Date: 23:32 2019/5/5
 * @Description:
 */
public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode(T val){
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        sb.append("[");
        while(node !=null){
            sb.append(node.val);
            if(node.next!=null){
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
