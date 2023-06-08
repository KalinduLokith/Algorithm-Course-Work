import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphFileParser
{
    /**
     * A directed graph is read from a file by the parse method, which returns it as a DirectedGraph object.
     * @param filename the file's name, which contains the graph data
     * @return the graph in the file is represented by a DirectedGraph object.
     * @throws FileNotFoundException if the data from the graph data cannot be found
     */
    public static AdjacencyListGraph parse(String filename) throws FileNotFoundException
    {
        // Creating a new DirectedGraph object to store the graph data
        AdjacencyListGraph graph = new AdjacencyListGraph();

        // Creating a new Scanner object to read from the file
        Scanner scanner = new Scanner(new File(filename));

        // Printing a separator to the console
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Retrieved Graph Data :-");

        while (scanner.hasNextLine())
        {

            String line = scanner.nextLine();

            String[] tokens = line.split("   ");


            if (tokens.length != 2)
            {
                continue;
            }

            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);


            System.out.println(from + " ----> "+ to);

            graph.addEdge(from, to);
        }
        System.out.println();

        scanner.close();

        return graph;
    }
}