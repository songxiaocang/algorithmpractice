package leetcode;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Songxc
 * @Date: 12:01 2019/8/10
 * @Description: 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * <p>
 * 思路：
 * 根据前序遍历的左端点在中序遍历序列中的index，确定左右子树，重建二叉树，然后不断递归直到叶子节点。
 * 时间复杂度为0（n），空间复杂度为0（n） （存储整个树的开销）
 */
public class T105_BuildTree {
    private int[] preorder;
    private int[] inorder;
    private Map<Integer, Integer> idxMap = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;

        int idx = 0;
        for (int val : inorder) {
            idxMap.put(val, idx++);
        }
        return constructTree(0, inorder.length);
    }

    public TreeNode constructTree(int left, int right) {
        if (left == right) {
            return null;
        }
        int preVal = preorder[preIndex];
        int rootIndex = idxMap.get(preVal);
        preIndex++;

        TreeNode root = new TreeNode(preVal);
        root.left = constructTree(left, rootIndex);
        root.right = constructTree(rootIndex + 1, right);
        return root;
    }
}
