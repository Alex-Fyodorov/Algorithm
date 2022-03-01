package lesson7.hw;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testGraph();        
//        testDfsAndBfs();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(10);
        Random random = new Random();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");


        graph.addEdge("A", "B", random.nextInt(100));
        graph.addEdge("B", "E", random.nextInt(100));
        graph.addEdge("E", "J", random.nextInt(100));
        graph.addEdge("A", "C", random.nextInt(100));
        graph.addEdge("C", "F", random.nextInt(100));
        graph.addEdge("F", "H", random.nextInt(100));
        graph.addEdge("H", "J", random.nextInt(100));
        graph.addEdge("A", "D", random.nextInt(100));
        graph.addEdge("D", "G", random.nextInt(100));
        graph.addEdge("G", "I", random.nextInt(100));
        graph.addEdge("I", "J", random.nextInt(100));
        graph.addEdge("E", "F", random.nextInt(100));
        graph.addEdge("C", "G", random.nextInt(100));
        graph.addEdge("G", "H", random.nextInt(100));

        System.out.println("Size of graph is: " + graph.getSize());
        graph.display();
        graph.shortestWay("A", "J");
    }

/*    private static void testDfsAndBfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
        graph.toCleanIsVisited();
        graph.bfs("A");
    }*/
}
