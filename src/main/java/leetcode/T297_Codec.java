package leetcode;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 19:30 2019/8/25
 * @Description: 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 *
 * 思路：
 *  两种方法：使用stringBuilder 或者 string ，都需要先序遍历
 *
 *  时间复杂度：在序列化和反序列化函数中，我们只访问每个节点一次，因此时间复杂度为 O(n)，其中 n 是节点数，即树的大小。
 * 空间复杂度：在序列化和反序列化函数中，我们将整棵树保留在开头或结尾，因此，空间复杂性为 O(n)。
 *
 *
 */
public class T297_Codec {
    //使用stringBuilder
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder sb = new StringBuilder(data);
        return rdeserialize(sb);
    }

    public TreeNode rdeserialize(StringBuilder sb) {
        if (sb.length() <= 0) {
            return null;
        }
        String val = sb.substring(0, sb.indexOf(","));
        sb.delete(0, sb.indexOf(",") + 1);
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = rdeserialize(sb);
        root.right = rdeserialize(sb);
        return root;
    }

    //使用string拼接 此种方式不建议采用，效率比较低
    public String rserialize2(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize2(root.left, str);
            str = rserialize2(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        return rserialize2(root, "");
    }

    public TreeNode rdeserialize2(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize2(l);
        root.right = rdeserialize2(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize2(data_list);
    }



}
