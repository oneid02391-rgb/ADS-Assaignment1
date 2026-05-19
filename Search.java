import java.util.HashMap;
import java.util.Map;

public class Search<V> {

    protected Map<Vertex<V>, Vertex<V>> edgeTo;

    public Search() {
        edgeTo = new HashMap<>();
    }

    public void pathTo(Vertex<V> vertex) {

        if (vertex == null) {
            return;
        }

        System.out.print(vertex + " ");

        while (edgeTo.containsKey(vertex)) {
            vertex = edgeTo.get(vertex);
            System.out.print(vertex + " ");
        }

        System.out.println();
    }
}
