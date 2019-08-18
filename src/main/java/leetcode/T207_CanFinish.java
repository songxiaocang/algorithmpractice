package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 19:46 2019/8/18
 * @Description:  课程表
 *  现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 *
 * 思路：
 *   有两种解决办法 入度表+拓扑排序（广度优先遍历）， 深度优先遍历
 *   1）拓扑排序（Kahn 算法）
 *   拓扑排序实际上应用的是贪心算法。贪心算法简而言之：每一步最优，全局就最优。
 *   算法流程：
 *
 * 1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 000 的结点放入队列。
 * 2、只要队列非空，就从队首取出入度为 000 的结点，将这个结点输出到结果集中，并且将这个结点的所有邻接结点（它指向的结点）的入度减 111，在减 111 以后，如果这个被减 111 的结点的入度为 000 ，就继续入队。
 * 3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。
 *
 * 在代码具体实现的时候，除了保存入度为 0 的队列，我们还需要两个辅助的数据结构：
 * 1、邻接表：通过结点的索引，我们能够得到这个结点的后继结点；
 * 2、入度数组：通过结点的索引，我们能够得到指向这个结点的结点个数。
 *
 * 时间复杂度：O(E+V)。这里 E 表示邻边的条数，V 表示结点的个数。初始化入度为 0 的集合需要遍历整张图，具体做法是检查每个结点和每条边，因此复杂度为 O(E+V), 然后对该集合进行操作，又需要遍历整张图中的每个结点和每条边，复杂度也为 O(E+V)；
 * 空间复杂度：O(V)：入度数组、邻接表的长度都是结点的个数 V，即使使用队列，队列最长的时候也不会超过 V，因此空间复杂度是 O(V)。
 *
 * 2) 深度优先遍历
 *  第 1 步：构建逆邻接表；
 * 第 2 步：递归处理每一个还没有被访问的结点，具体做法很简单：对于一个结点来说，先输出指向它的所有顶点，再输出自己。
 * 第 3 步：如果这个顶点还没有被遍历过，就递归遍历它，把所有指向它的结点都输出了，再输出自己。注意：当访问一个结点的时候，应当先递归访问它的前驱结点，直至前驱结点没有前驱结点为止。
 *
 * 时间复杂度 O(E+V)：遍历一个图需要访问所有节点和所有临边，E 和 V 分别为节点数量和临边数量；
 * 空间复杂度 O(V)，为建立邻接矩阵所需额外空间。
 *
 */
public class T207_CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        int plen = prerequisites.length;
        if (plen == 0) {
            return true;
        }
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        // 拓扑排序的结果
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer num = queue.removeFirst();
            res.add(num);
            // 把邻边全部遍历一下
            for (int[] p : prerequisites) {
                if (p[1] == num) {
                    inDegree[p[0]]--;
                    if (inDegree[p[0]] == 0) {
                        queue.addLast(p[0]);
                    }
                }
            }
        }
        return res.size() == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        int plen = prerequisites.length;
        if (plen == 0) {
            return true;
        }
        int[] marked = new int[numCourses];

        // 初始化有向图 begin
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        // 初始化有向图 end
        // 有向图的 key 是前驱结点，value 是后继结点的集合
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, marked)) {
                // 注意方法的语义，如果图中存在环，表示课程任务不能完成，应该返回 false
                return false;
            }
        }
        // 在遍历的过程中，一直 dfs 都没有遇到已经重复访问的结点，就表示有向图中没有环
        // 所有课程任务可以完成，应该返回 true
        return true;
    }

    /**
     * 注意这个 dfs 方法的语义
     *
     * @param i      当前访问的课程结点
     * @param graph
     * @param marked 如果 == 1 表示正在访问中，如果 == 2 表示已经访问完了
     * @return true 表示图中存在环，false 表示访问过了，不用再访问了
     */
    private boolean dfs(int i,
                        HashSet<Integer>[] graph,
                        int[] marked) {
        // 如果访问过了，就不用再访问了
        if (marked[i] == 1) {
            // 从正在访问中，到正在访问中，表示遇到了环
            return true;
        }

        if (marked[i] == 2) {
            // 表示在访问的过程中没有遇到环，这个节点访问过了
            return false;
        }
        // 走到这里，是因为初始化呢，此时 marked[i] == 0
        // 表示正在访问中
        marked[i] = 1;
        // 后继结点的集合
        HashSet<Integer> successorNodes = graph[i];

        for (Integer successor : successorNodes) {
            if (dfs(successor, graph, marked)) {
                // 层层递归返回 true ，表示图中存在环
                return true;
            }
        }
        // i 的所有后继结点都访问完了，都没有存在环，则这个结点就可以被标记为已经访问结束
        // 状态设置为 2
        marked[i] = 2;
        // false 表示图中不存在环
        return false;
    }

}
