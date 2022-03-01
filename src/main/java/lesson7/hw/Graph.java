package lesson7.hw;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String endLabel, int length);

    int getSize();

    void display();

    /**
     * Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * Breadth-first search, BFS
     */
    void bfs(String startLabel);

    void toCleanIsVisited();

    void shortestWay(String startLabel, String endLabel);
}
