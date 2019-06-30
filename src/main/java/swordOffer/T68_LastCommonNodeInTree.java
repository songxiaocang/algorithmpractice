package swordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 17:02 2019/6/30
 * @Description: 树中两个节点的最低公共祖先
 * 思路：
 * 有多种解法。
 * 1） 从根节点开始遍历左右子树，两个节点在当前节点的子树中但是不在当前节点子节点的子树中，满足这样的条件即可。时间复杂度为0(n2)
 * 2）使用list保存从根节点开始到目标节点的路径，然后求解这两条路径的最后一个相同节点。时间复杂度为0(n), 空间复杂度为0(logN)
 */
public class T68_LastCommonNodeInTree {

    public static class CommonTreeNode {
        private char val;
        private List<CommonTreeNode> children;

        public CommonTreeNode(char val) {
            this.val = val;
            children = new LinkedList<>();
        }

        public void addNode(CommonTreeNode... nodes) {
            for (CommonTreeNode node : nodes) {
                this.children.add(node);
            }
        }

        @Override
        public String toString() {
            return "curNode: val=> " + this.val;
        }
    }

    public static CommonTreeNode getLastCommonNode(CommonTreeNode root, CommonTreeNode node1, CommonTreeNode node2) {
        List<CommonTreeNode> path1 = new ArrayList<>();
        List<CommonTreeNode> path2 = new ArrayList<>();
        getPath(root, node1, path1);
        getPath(root, node2, path2);
        CommonTreeNode commonParentTreeNode = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                commonParentTreeNode = path1.get(i);
            }
        }
        return commonParentTreeNode;
    }

    public static boolean getPath(CommonTreeNode root, CommonTreeNode node, List<CommonTreeNode> path) {
        if (root == node) {
            return true;
        }
        path.add(root);
        for (CommonTreeNode curNode : root.children) {
            if (getPath(curNode, node, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        CommonTreeNode root = new CommonTreeNode('A');
        CommonTreeNode b = new CommonTreeNode('B');
        CommonTreeNode c = new CommonTreeNode('C');
        CommonTreeNode d = new CommonTreeNode('D');
        CommonTreeNode e = new CommonTreeNode('E');
        CommonTreeNode f = new CommonTreeNode('F');
        CommonTreeNode g = new CommonTreeNode('G');
        CommonTreeNode h = new CommonTreeNode('H');
        CommonTreeNode i = new CommonTreeNode('I');
        CommonTreeNode j = new CommonTreeNode('J');
        root.addNode(b, c);
        b.addNode(d, e);
        d.addNode(f, g);
        e.addNode(h, i, j);

        System.out.println(getLastCommonNode(root, f, h));
        System.out.println(getLastCommonNode(root, i, j));

    }
}
