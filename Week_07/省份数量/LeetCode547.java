package cn.zwq.algorithm.middle;

/**
 * 547. 省份数量
 *
 * @author G20200343200113
 */
public class LeetCode547 {

    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;

        //找连通子图数量
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    //合并处于同一连通子图的两点
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    //查找根节点
    public int find(int[] parent, int index) {
        while (index != parent[index]) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
