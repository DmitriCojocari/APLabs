package optional.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomGraph {

    public int vertices;
    public int edges;

    Random random = new Random();

    public List<List<Integer>> adjacencyList;

    int maxEdges(int nrOfVertices) {
        return nrOfVertices * ((nrOfVertices - 1) / 2);
    }

    public GenerateRandomGraph(int vertices) {
        this.vertices = vertices;
        //the number of edges will be the max number of edges possible
        this.edges = maxEdges(vertices);
        //representation of graph by adjacency list for vertices
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            //randomly select 2 vertices
            int u = random.nextInt(vertices);
            int v = random.nextInt(vertices);
            //if we have already an edge between and u and v
            if ((u == v) || adjacencyList.get(u).contains(v)) {
                //decrease i so u and v can be selected for next
                i = i - 1;
                continue;
            }
            addEdge(u, v);
        }
    }

    void addEdge(int u, int v) {
        //we find u in the list, and add v to its adjacency list
        adjacencyList.get(u).add(v);
        //same for v
        adjacencyList.get(v).add(u);
    }


    public static void main(String[] args) {
        int n = 0;
        if (args.length < 1) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }
        if (args.length > 0) {
            try {
                n = Math.abs(Integer.parseInt(args[0]));
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
        if (n > 100) {
            long startTime = System.nanoTime();
            GenerateRandomGraph graph = new GenerateRandomGraph(n);
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        } else {
            GenerateRandomGraph graph = new GenerateRandomGraph(n);

            System.out.println("The generated random graph :");

            for (int i = 0; i < graph.adjacencyList.size(); i++) {
                System.out.print(i + " -> { ");

                List<Integer> list = graph.adjacencyList.get(i);

                if (list.isEmpty())
                    System.out.print(" No adjacent vertices ");
                else {
                    int size = list.size();
                    for (int j = 0; j < size; j++) {

                        System.out.print(list.get(j));
                        if (j < size - 1)
                            System.out.print(" , ");
                    }
                }

                System.out.println("}");
            }
        }
    }
}

