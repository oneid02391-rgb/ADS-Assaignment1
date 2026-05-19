import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    private Set<Vertex<V>> marked;

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {

        marked = new HashSet<>();

        Queue<Vertex<V>> queue = new LinkedList<>();

        marked.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {

            Vertex<V> current = queue.poll();

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {

                if (!marked.contains(neighbor)) {

                    marked.add(neighbor);
                    edgeTo.put(neighbor, current);

                    queue.add(neighbor);
                }
            }
        }
    }

    public boolean hasPathTo(Vertex<V> vertex) {
        return marked.contains(vertex);
    }
}
