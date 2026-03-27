// Java Program to Implement Prim's Algorithm
import java.util.*;

// Class to represent an edge in the graph
class PrimEdge {
    int source;
    int dest;
    int weight;

    // Constructor to initialize an edge
    PrimEdge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

// Class to represent the graph
class PrimGraph {
    int vertices;
    LinkedList<PrimEdge>[] adjacencyList;

    // Constructor to initialize the graph with
    // the given number of vertices
    PrimGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    void addPrimEdge(int source, int dest, int weight) {
        PrimEdge edge = new PrimEdge(source, dest, weight);
        adjacencyList[source].add(edge);

        // Adding the reverse edge since it's an undirected graph
        adjacencyList[dest].add(new PrimEdge(dest, source, weight));
    }

    // Method to implement Prim's algorithm to
    // find the Minimum Spanning Tree (MST)
    void primMST() {
        // Array to keep track of vertices included in MST
        boolean[] inMST = new boolean[vertices];

        // Priority queue to select the edge
        // with the smallest weight
        PriorityQueue<PrimEdge> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // List to store the MST edges
        List<PrimEdge> mst = new ArrayList<>();

        // Start from any vertex, here it's 0
        int startVertex = 0;

        // Mark the start vertex as included in MST
        inMST[startVertex] = true;

        // Add all edges from the start vertex to the priority queue
        for (PrimEdge edge : adjacencyList[startVertex]) {
            priorityQueue.add(edge);
        }

        // Process the edges in the priority queue
        while (!priorityQueue.isEmpty()) {
            // // Get the edge with the smallest weight
            PrimEdge currentPrimEdge = priorityQueue.poll();

            // If the destination vertex is not yet
            // included in MST
            if (!inMST[currentPrimEdge.dest]) {
                // Add the edge to the MST
                mst.add(currentPrimEdge);

                // Mark the destination vertex as included in MST
                inMST[currentPrimEdge.dest] = true;

                // Add all edges from the current edge's
                // destination to the priority queue
                for (PrimEdge edge : adjacencyList[currentPrimEdge.dest]) {
                    if (!inMST[edge.dest]) {
                        priorityQueue.add(edge);
                    }
                }
            }
        }

        // Print the edges in the MST
        int PrimSUM = 0;
        System.out.println("\nMinimum Spanning Tree (Prim):");
        for (PrimEdge edge : mst) {
            System.out.println("PrimEdge: " + edge.source + " - "
                    + edge.dest + " Weight: " + edge.weight);
        }
        for(PrimEdge edge : mst) {
            PrimSUM += edge.weight;
        }
        System.out.println("Total MST Cost = " + PrimSUM);
    }
}
