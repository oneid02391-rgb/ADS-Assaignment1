import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {

    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public void addEdge(V source, V destination, double weight) {

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destinationVertex = vertices.get(destination);

        if (sourceVertex != null && destinationVertex != null) {
            sourceVertex.addAdjacentVertex(destinationVertex, weight);
        }
    }

    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }
}
