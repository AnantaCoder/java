package Graphs;

import java.util.*;

public class GraphBasics {

    public void dfs(Map<Integer, List<Integer>> graph, int start){
        //Use BFS for: shortest path in unweighted graph, level-order problems.
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();


        queue.offer(start);
        visited.add(start);


        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node + " ");

            for(int neighbor: graph.getOrDefault(node,new ArrayList<>())){

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            
        }
    }


    void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {

    //Use DFS for: cycle detection, connected components, topological sort.
    visited.add(node);
    System.out.print(node + " ");
    
    for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
        if (!visited.contains(neighbor)) {
            dfs(graph, neighbor, visited);
        }
    }
}




    public static void main(String[] args) {

        // unweighted graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // add edge between between 1,2
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(2);
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(1);

        // adjacency matrix representation

        int i = 0,j = 0,n=2;
        int[][] matrix = new int[n][n];
        matrix[i][j] = 1; // edge from i to j
        matrix[j][i] = 1; // undirected: add both

        // Best for dense graphs or when you need O(1) edge lookup.

        // 3. Edge List
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        // Used for algorithms like Kruskal's MST.
    }
}
