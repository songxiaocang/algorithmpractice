package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Author: Songxc
 * @Date: 16:07 2019/9/8
 * @Description:  除法求值
 *  给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 *
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 *
 * 基于上述例子，输入如下：
 *
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 *
 * 思路：
 *   构造图 + DFS
 *
 */
public class T399_CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            res[i] = queryRes(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return res;
    }

    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values){
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            if(graph.get(equations.get(i).get(0)) == null){
                graph.put(equations.get(i).get(0), new HashMap<String, Double>());
            }
            graph.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            if(graph.get(equations.get(i).get(1)) == null){
                graph.put(equations.get(i).get(1), new HashMap<String, Double>());
            }
            graph.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1/values[i]);
        }
        return graph;

    }

    public double queryRes(HashMap<String, HashMap<String, Double>> graph, String start, String end, HashSet<String> visited){
        if(!graph.containsKey(start)){
            return -1.0;
        }
        if(graph.get(start).containsKey(end)){
            return graph.get(start).get(end);
        }
        visited.add(start);
        for(Map.Entry<String, Double> item : graph.get(start).entrySet()){
            if(!visited.contains(item.getKey())){
                double t = queryRes(graph, item.getKey(), end, visited);
                if(t != -1.0){
                    return t*item.getValue();
                }
            }
        }

        return -1.0;
    }

}
