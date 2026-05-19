public class Main {

    public static void main(String[] args) {

        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "D", 1);
        graph.addEdge("C", "D", 7);

        Vertex<String> start = graph.getVertex("A");
        Vertex<String> end = graph.getVertex("D");

        System.out.println("BFS:");

        BreadthFirstSearch<String> bfs =
                new BreadthFirstSearch<>(graph, start);

        bfs.pathTo(end);

        System.out.println();

        System.out.println("Dijkstra:");

        DijkstraSearch<String> dijkstra =
                new DijkstraSearch<>(graph, start);

        dijkstra.pathTo(end);

        System.out.println(
                "Distance: " + dijkstra.distanceTo(end)
        );
    }
}
