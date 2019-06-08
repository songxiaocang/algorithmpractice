package swordOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: Songxc
 * @Date: 23:35 2019/6/8
 * @Description: 数据流中的中位数
 * 思路：
 *  有三种解法：
 *      解法        排序数组     二叉搜索树       堆（大顶堆和小顶堆）
 *   时间复杂度     O(n)          O(logn)         O(logn)
 */
public class T41_FindMedian {
    //排序数组（快排分区算法）
    public interface Median{
        void addNum(double num);
        double findMedian();
    }
    public static class FindMedian1 implements Median{
        List<Double> list = null;
        public FindMedian1(){
            list = new ArrayList<>();
        }

        @Override
        public void addNum(double num) {
            list.add(num);
        }

        @Override
        public double findMedian() {
            if (list.size() == 0){
                return 0;
            }
            if((list.size()&1) == 1){
                return findMedianNum(list.size()>>1);
            }else{
                return (findMedianNum(list.size()>>1)+findMedianNum((list.size()>>1)-1))/2;
            }

        }

        public double findMedianNum(int size){
            int left = 0;
            int right = list.size() - 1;
            int index = partition(left, right);
            while(index != size){
                if (index < size){
                    index = partition(index+1, right);
                }else{
                    index = partition(left, index-1);
                }
            }
            return list.get(index);
        }

        public int partition(int left, int right){
            if (left>=right){
                return right;
            }
            double pivot = list.get(left);
            int bound = left;
            for(int i=left+1;i<=right;i++){
                if (list.get(i)<pivot){
                    list.set(bound,list.get(i));
                    bound++;
                    list.set(i,list.get(bound));
                }
            }
            list.set(bound,pivot);
            return bound;
        }
    }


    // 二叉搜索树
    public static class FindMedian2 implements Median{
        class TreeNode{
            double val;
            TreeNode leftNode;
            TreeNode rightNode;
            int nodes;

            public TreeNode(double val){
                this.val = val;
                this.leftNode = null;
                this.rightNode = null;
                this.nodes = 1;
            }
        }

        TreeNode root = null;

        public FindMedian2(){}

        @Override
        public void addNum(double num) {
            if (root == null){
                root = new TreeNode(num);
            }else{
                addNum(root, num);
            }
        }

        public void addNum(TreeNode node, double val){
            if (val < node.val){
                if(node.leftNode == null){
                    node.leftNode = new TreeNode(val);
                    node.nodes++;
                }else{
                    addNum(node.leftNode, val);
                }
            }else{
                if (node.rightNode == null){
                    node.rightNode = new TreeNode(val);
                    node.nodes++;
                }else{
                    addNum(node.rightNode, val);
                }
            }
        }

        @Override
        public double findMedian() {
            if (root == null){
                return 0;
            }
            if((root.nodes&1) == 1){
                return findMedian(root, root.nodes/2+1);
            }else{

                return (findMedian(root, root.nodes/2)+findMedian(root, root.nodes/2+1))/2;
            }

        }

        public double findMedian(TreeNode node, int index){
            if (node.leftNode != null){
                if (index == node.leftNode.nodes){
                    return node.val;
                }else if(index <= node.leftNode.nodes){
                    return findMedian(node.leftNode, index);
                }else{
                    return findMedian(node.rightNode, index - node.leftNode.nodes -1);
                }
            }else if(node.rightNode != null){
                return findMedian(node.rightNode, index-1);
            }else{
                return node.val;
            }
        }
    }

    //大顶堆和小顶堆
    public static class FindMedian3 implements Median{
        public PriorityQueue<Double> rightHeap = new PriorityQueue<>();
        public PriorityQueue<Double> leftHeap = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o2-o1);
            }
        }
        );
        int count = 0;

        public FindMedian3(){}

        @Override
        public void addNum(double num) {
            if (count%2==0){
                //偶数，进入小顶堆，先进入大顶堆筛选一下
                leftHeap.offer(num);
                double val = leftHeap.poll();
                rightHeap.offer(val);
            }else{
                //奇数，进入大顶堆，先进入小顶堆筛选以下
                rightHeap.offer(num);
                double val = rightHeap.poll();
                leftHeap.offer(val);
            }
            count++;
        }

        @Override
        public double findMedian() {
            if (count%2 == 0){
                return (leftHeap.peek()+rightHeap.peek())/2;
            }else{
                return rightHeap.peek()/2;
            }
        }
    }

    public static void main(String[] args) {
        FindMedian1 findMedian1 = new FindMedian1();
        findMedian1.addNum(2d);
        findMedian1.addNum(5d);
        findMedian1.addNum(3d);
        findMedian1.addNum(4d);
        findMedian1.addNum(8d);
        findMedian1.addNum(6d);

        System.out.println(findMedian1.findMedian());

        FindMedian2 findMedian2 = new FindMedian2();
        findMedian2.addNum(2d);
        findMedian2.addNum(5d);
//        findMedian2.addNum(3d);
//        findMedian2.addNum(4d);
//        findMedian2.addNum(8d);
//        findMedian2.addNum(6d);
        System.out.println(findMedian2.findMedian());

        FindMedian3 findMedian3 = new FindMedian3();
        findMedian3.addNum(2d);
        findMedian3.addNum(5d);
        findMedian3.addNum(3d);
        findMedian3.addNum(4d);
        findMedian3.addNum(8d);
        findMedian3.addNum(6d);
        System.out.println(findMedian3.findMedian());
    }

}
