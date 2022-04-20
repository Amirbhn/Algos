package applciation;

import model.Vertex;

import java.util.*;

public class BreadthFirstSearch<T> {
  private final Vertex<T> startVertex;

  public BreadthFirstSearch(Vertex<T> startVertex) {
    this.startVertex = startVertex;
  }

  public void traverseBreadthDepth() {
    Queue<Vertex<T>> queue = new LinkedList<>();
    queue.add(startVertex);
    while (!queue.isEmpty()) {
      Vertex<T> current = queue.poll();
      if (!current.isVisited()) {
        current.setVisited(true);
        System.out.println(current);
        queue.addAll(current.getNeighbors());
      }
    }
  }

  public static void main(String[] args) {
    Vertex<Integer> v0 = new Vertex<>(0);
    Vertex<Integer> v1 = new Vertex<>(1);
    Vertex<Integer> v2 = new Vertex<>(2);
    Vertex<Integer> v3 = new Vertex<>(3);
    Vertex<Integer> v4 = new Vertex<>(4);
    Vertex<Integer> v5 = new Vertex<>(5);
    Vertex<Integer> v6 = new Vertex<>(6);
    v0.setNeighbors(Arrays.asList(v1, v5, v6));
    v1.setNeighbors(Arrays.asList(v3, v4, v5));
    v4.setNeighbors(Arrays.asList(v2, v6));
    v6.setNeighbors(List.of(v0));
    BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(v1);
    bfs.traverseBreadthDepth();
  }
}
