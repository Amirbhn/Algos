package applciation;

import model.Vertex;

import java.util.*;

public class DepthFirstSearch<T> {
    private final Vertex<T> startVertex;

    public DepthFirstSearch(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }


    public void traverseDepthFirst(Vertex <T> startVertex) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                Collections.reverse(current.getNeighbors() );
                current.getNeighbors().forEach(stack::push);
            }
        }
    }

    public static void main(String[] args) {
        Vertex <Integer> v0 = new Vertex<>(0);
        Vertex <Integer> v1 = new Vertex<>(1);
        Vertex <Integer> v2 = new Vertex<>(2);
        Vertex <Integer> v3 = new Vertex<>(3);
        Vertex <Integer> v4 = new Vertex<>(4);
        Vertex <Integer> v5 = new Vertex<>(5);
        Vertex <Integer> v6 = new Vertex<>(6);
        v0.setNeighbors(Arrays.asList(v1,v5,v6));
        v1.setNeighbors(Arrays.asList(v3,v4,v5));
        v4.setNeighbors(Arrays.asList(v2,v6));
        v6.setNeighbors(List.of(v0));

        DepthFirstSearch<Integer> bfs = new DepthFirstSearch<>(v1);
//bfs.traverseBreadthDepth();
        System.out.println("--------------");
        bfs.traverseDepthFirst(v1);

    }
}
