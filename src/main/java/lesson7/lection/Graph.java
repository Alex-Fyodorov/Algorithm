package lesson7.lection;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);
    boolean addEdge(String startLabel, String secondLabel);

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
}
