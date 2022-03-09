package lesson7.hw;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String endLabel, int length) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = length;
        adjMatrix[endIndex][startIndex] = length;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            for (int j = i; j < getSize(); j++) {
                if (adjMatrix[i][j] != null) {
                    sb.append(vertexList.get(i))
                    .append(" -> ").append(vertexList.get(j))
                    .append(" = ").append(adjMatrix[i][j]).append("\n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != null && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }
        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
        System.out.println();
    }

    @Override
    public void toCleanIsVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    /**
     * Решил задачу через рекурсию. Да, я знаю, что это не самый лучший вариант,
     * и в случае большого количества точек очень быстро кончится память, зато
     * данный метод исключает зацикливание.
     */
    @Override
    public void shortestWay(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        Vertex current = vertexList.get(startIndex);
        int length = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(current.getLabel());
        toCleanIsVisited();
        Map<String, Integer> map = new HashMap<>();
        findWay(current, endLabel, length, sb, map);
        int min = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            for (int j = 0; j < vertexList.size(); j++) {
                if (adjMatrix[i][j] != null) {
                    min += adjMatrix[i][j];
                }
            }
        }
        String way = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (min > entry.getValue()) {
                min = entry.getValue();
                way = entry.getKey();
            }
        }
        System.out.println("\n" + "Самый короткий путь: " + min);
        System.out.println(way);
    }

    private void findWay(Vertex current, String endLabel, int length,
                         StringBuilder sb, Map<String, Integer> map) {
        if (current.getLabel().equals(endLabel)) {
            sb.append(" = ").append(length);
            map.put(String.valueOf(sb), length);
            System.out.println(sb);
            return;
        }
        current.setVisited(true);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[indexOf(current.getLabel())][i] != null &&
                    !vertexList.get(i).isVisited()) {
                int lengthTwo = length + adjMatrix[indexOf(current.getLabel())][i];
                StringBuilder sbTwo = new StringBuilder(sb);
                sbTwo.append(" -> ").append(vertexList.get(i).getLabel());
                findWay(vertexList.get(i), endLabel, lengthTwo, sbTwo, map);
            }
        }
        current.setVisited(false);
    }
}
