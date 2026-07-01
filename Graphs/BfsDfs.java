package Graphs;

import java.util.*;

public class BfsDfs extends Node {
    public int findCircleNum(int[][] isConnected) {
        // leetcode-547 number of provinces

        /*
         * There are n cities. Some of them are connected, while some are not. If city a
         * is connected directly with city b, and city b is connected directly with city
         * c, then city a is connected indirectly with city c.
         * 
         * A province is a group of directly or indirectly connected cities and no other
         * cities outside of the group.
         * 
         * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
         * ith city and the jth city are directly connected, and isConnected[i][j] = 0
         * otherwise.
         * 
         * Return the total number of provinces.
         */

        // according to my thuinging i need to find the is theres path exist btween to
        // since its a undirected graph

        int n = isConnected.length;

        // convert matrix to adjacency list

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());

            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }

            }

        }

        // applaying dfs

        Set<Integer> visited = new HashSet<>();

        int provinces = 0;

        for (int k = 0; k < n; k++) {
            if (!visited.contains(k)) {
                dfs(graph, k, visited);
                provinces++;
            }
        }

        return provinces;

    }

    // this is adjacency list solution to thus problem
    public static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);

            }
        }
        ;
    }
    // -------------------------------------------------------------------------------------------

    public int findCircleNum2(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                matrixDFS(isConnected, i, visited);
                provinces++;
            }

        }

        return provinces;
    }

    // for input matrix dfs
    public static void matrixDFS(int[][] graph, int city, boolean[] visited) {
        visited[city] = true;

        for (int next = 0; next < graph.length; next++) {
            if (graph[city][next] == 1 && !visited[next]) {
                matrixDFS(graph, next, visited);
            }
        }

    }

    // -------------------------------------------------------------------------------------------

    public int orangesRotting(int[][] grid) {
        // leetcode-994. Rotting Oranges

        /*
         * 1 . Create a visited grid to store the state of the cell (fresh, rotten, or
         * empty).
         * 2. Initialize a queue to store the rotten oranges and count the number of
         * fresh oranges.
         * 3. Check if there are no fresh oranges, return 0, or if there are no rotten
         * oranges, return -1.
         * 4. Loop while the queue is not empty.
         * a. Store the size of the queue.
         * b. Loop through the size of the queue.
         * i. Get the front cell of the queue.
         * ii. Check all four directions of the cell to see if there are any fresh
         * oranges.
         * iii. If there is a fresh orange, change its state to rotten and decrement the
         * count of fresh oranges, and push the cell into the queue.
         * c. Increment the minutes.
         * 5. If there are no fresh oranges, return the minutes.
         * 6. If there are still fresh oranges, return -1.
         */

        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = grid;

        Queue<int[]> queue = new LinkedList<>();

        int countFreshOranges = 0;

        for (int i = 0; i < m; i++) {
            {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 2) {
                        queue.offer(new int[] { i, j });
                    }
                    if (visited[i][j] == 1) {
                        countFreshOranges++;

                    }

                }
            }

        }

        if (countFreshOranges == 0)
            return 0;
        if (queue.isEmpty())
            return -1;

        int minutes = -1;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // up down left right
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 1) {
                        visited[i][j] = 2;
                        countFreshOranges--;
                        queue.offer(new int[] { i, j });

                    }
                }

            }

            minutes++;

        }
        if (countFreshOranges == 0) {
            return minutes;
        }

        return -1;

    }
    // -------------------------------------------------------------------------------------------

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // Nothing to change
        if (originalColor == color) {
            return image;
        }

        Colordfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void Colordfs(int[][] image, int row, int col, int originalColor, int newColor) {

        // base

        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length)
            return;

        if (image[row][col] != originalColor)
            return; // diff color

        // current

        image[row][col] = newColor;

        Colordfs(image, row - 1, col, originalColor, newColor); // Up
        Colordfs(image, row + 1, col, originalColor, newColor); // Down
        Colordfs(image, row, col - 1, originalColor, newColor); // Left
        Colordfs(image, row, col + 1, originalColor, newColor); // Right
    }

    // -------------------------------------------------------------------------------------------

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // leetcode-1971. Find if Path Exists in Graph
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return dfsHelper(
                adjList,
                visited,
                source,
                destination);
    }

    private boolean dfsHelper(List<List<Integer>> adjList,
            boolean[] visited,
            int vertex,
            int destination) {

        if (vertex == destination) {
            return true;
        }

        visited[vertex] = true;

        for (int neighbour : adjList.get(vertex)) {

            if (!visited[neighbour]) {

                if (dfsHelper(
                        adjList,
                        visited,
                        neighbour,
                        destination)) {

                    return true;
                }
            }
        }

        return false;
    }

    // -------------------------------------------------------------------------------------------

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // leetcode-841. Keys and Rooms
        boolean[] visited = new boolean[rooms.size()];
        // Queue<Integer> queue = new LinkedList<>();

        // visited[0] = true;
        // queue.add(0);

        // int roomsVisitedCount = 1;

        // while (!queue.isEmpty()) {
        // int current = queue.poll();

        // for(int key : rooms.get(current)){
        // if(!visited[key]){
        // visited[key] = true;
        // queue.add(key);
        // roomsVisitedCount++;

        // if(roomsVisitedCount== rooms.size()){
        // return true;
        // }
        // }
        // }

        // }

        // return roomsVisitedCount==rooms.size();

        dfsKeysRooms(rooms, visited, 0);

        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;
    }

    private void dfsKeysRooms(List<List<Integer>> rooms, boolean[] visited, int room) {
        visited[room] = true;

        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfsKeysRooms(rooms, visited, key);
            }
        }
    }

    // -------------------------------------------------------------------------------------------
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // leetcode-133 clone craph 
        if(node == null) return null;

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node clone = new Node(node.val);

        map.put(node, clone);

        for(Node neigh : node.neighbors){
            clone.neighbors.add((cloneGraph(neigh)));
        }
        return clone;
    }

    //--------------------------------------------------------------------------------------------
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
