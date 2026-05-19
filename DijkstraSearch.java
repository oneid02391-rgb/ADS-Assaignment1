import java.util.*;

public class DijkstraSearch<V> extends Search<V> {

    private Map<Vertex<V>, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {

        distTo = new HashMap<>();

        for (Vertex<V> vertex : graph.getVertices()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }

        distTo.put(source, 0.0);

        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                Comparator.comparingDouble(distTo::get)
        );

        pq.add(source);

        while (!pq.isEmpty()) {

            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry :
                    current.getAdjacentVertices().entrySet()) {

                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDistance = distTo.get(current) + weight;

                if (newDistance < distTo.get(neighbor)) {

                    distTo.put(neighbor, newDistance);
                    edgeTo.put(neighbor, current);

                    pq.add(neighbor);
                }
            }
        }
    }

    public double distanceTo(Vertex<V> vertex) {
        return distTo.get(vertex);
    }
}
