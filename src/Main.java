import java.util.Arrays;

public class Main {
    public static void main(String args[])
    {
        //Quick Sort
        QuickSort ob = new QuickSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("\nOriginal Array:");
        System.out.println(Arrays.toString(nums));
        ob.sort(nums);
        System.out.println("Quick Sorted Array:");
        System.out.println(Arrays.toString(nums));

        //Bubble Sort
        BubbleSort ob2 = new BubbleSort();
        int nums2[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("\nOriginal Array:");
        System.out.println(Arrays.toString(nums2));
        ob2.bubbleSort(nums2);
        System.out.println("Bubble Sorted Array:");
        System.out.println(Arrays.toString(nums2));

        //Radix Sort
        RadixSort ob3 = new RadixSort();
        int nums3[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("\nOriginal Array:");
        System.out.println(Arrays.toString(nums3));
        ob3.sort(nums3);
        System.out.println("Radix Sorted Array:");
        System.out.println(Arrays.toString(nums3));

        //Kruskal
        int V = 4; // Number of vertices
        int E = 5; // Number of edges

        Graph graph = new Graph(V, E);

        // Add edges
        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        // Function call to find MST using Kruskal's algorithm
        graph.kruskalMST();

        PrimGraph graph2 = new PrimGraph(4);

        // Add edges to the graph
        graph2.addPrimEdge(0, 1, 1);
        graph2.addPrimEdge(1, 2, 2);
        graph2.addPrimEdge(2, 3, 3);
        graph2.addPrimEdge(0, 3, 4);

        // Find and print the MST using Prim's algorithm
        graph2.primMST();

        int number = 5;
        int result = Factorial.factorial(number);
        System.out.println("\nFactorial of " + number + " is : " + result);


        // Given Number N
        int FiboN = 3;

        System.out.println("\nFibbonaci Sequence: ");
        for (int i = 0; i < FiboN; i++) {
            System.out.print(Fibonacci.fib(i) + " ");
        }

        int HanoiN = 2;

        System.out.println("\n\nTower Of Hanoi: ");
        // A, B and C are names of rods
        TowerOfHanoi.towerOfHanoi(HanoiN, 'A', 'C', 'B');
    }
}