package Interview;


import java.util.*;

public class GenerateData {
    public static void main(String[] args) {
        // Generate a seed for the random number generator based on the input email address
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter the email:");
    	String email=sc.nextLine();
        //String email = "abc@email.com";
        int seed = getSeed(email);
        Random random = new Random(seed);

        // Generate a random number of nodes (between 5 and 14)
        List<String> nodes = generateNodes(random);

        // Generate edges based on the nodes
        List<Edge> edges = generateEdges(random, nodes);

        // Print the generated nodes and edges
        System.out.println("Nodes: " + nodes);
        System.out.println("Edges: ");
        for (Edge edge : edges) {
            System.out.println(edge.toString());
        }
    }

    // Generate a seed for the random number generator based on the input email address
    public static int getSeed(String email) {
        int seed = 0;
        for (int i = 0; i < email.length(); i++) {
            seed += (int) email.charAt(i);
        }
        return seed;
    }

    // Generate a random number of nodes between 5 and 14
    public static List<String> generateNodes(Random random) {
        List<String> nodes = new ArrayList<>();
        int numNodes = random.nextInt(10) + 5; // Random number of nodes between 5 and 14
        for (int i = 0; i < numNodes; i++) {
            String node = generateNode(random);
            while (nodes.contains(node)) {
                node = generateNode(random);
            }
            nodes.add(node);
        }
        return nodes;
    }

    // Generate a random node name consisting of two uppercase letters
    public static String generateNode(Random random) {
        return String.valueOf((char) (random.nextInt(26) + 'A')) +
               String.valueOf((char) (random.nextInt(26) + 'A'));
    }

    // Generate edges based on the nodes
    public static List<Edge> generateEdges(Random random, List<String> nodes) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (random.nextBoolean()) {
                    double cost = random.nextDouble() * 10; // Random cost between 0 and 10
                    edges.add(new Edge(nodes.get(i), nodes.get(j), cost));
                }
            }
        }
        return edges;
    }

    // Define a class for the edges
    public static class Edge {
        String from;
        String to;
        double cost;

        public Edge(String from, String to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        // Override the toString method to print the edge in a readable format
        @Override
        public String toString() {
            return "{\"from\": \"" + from + "\", \"to\": \"" + to + "\", \"cost\": " + cost + "}";
        
        /*This is just a sample output.
         * 
         The output will vary each time you run the program due to the randomness introduced by the Random class.






*/
            
        }
    }
}
