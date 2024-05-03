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
        
        
            
        }
    }
}

/*This is just a sample output.
The output will vary each time you run the program due to the randomness introduced by the Random class.
enter the email:
abc@email.com
Nodes: [CO, OA, HR, EJ, OD, TI, VN, UN, GL, NM, JA, GT, XA]
Edges: 
{"from": "CO", "to": "OA", "cost": 8.819351356077975}
{"from": "CO", "to": "HR", "cost": 9.673100604387354}
{"from": "CO", "to": "EJ", "cost": 1.7723464582987414}
{"from": "CO", "to": "GL", "cost": 3.349094525041527}
{"from": "CO", "to": "JA", "cost": 5.952370912891953}
{"from": "CO", "to": "GT", "cost": 0.9701352265711416}
{"from": "OA", "to": "HR", "cost": 7.591660500716334}
{"from": "OA", "to": "EJ", "cost": 2.321197923942886}
{"from": "OA", "to": "TI", "cost": 9.495281155909312}
{"from": "OA", "to": "GL", "cost": 8.814122970965842}
{"from": "OA", "to": "GT", "cost": 0.9205616498432723}
{"from": "OA", "to": "XA", "cost": 1.9274808167937074}
{"from": "HR", "to": "UN", "cost": 8.706523309483423}
{"from": "HR", "to": "XA", "cost": 4.102829873890536}
{"from": "EJ", "to": "OD", "cost": 0.590065912499127}
{"from": "EJ", "to": "TI", "cost": 7.771067953587325}
{"from": "EJ", "to": "VN", "cost": 3.5453385626776104}
{"from": "EJ", "to": "GL", "cost": 7.207855376311793}
{"from": "EJ", "to": "JA", "cost": 9.39142483424325}
{"from": "EJ", "to": "GT", "cost": 9.705151519929432}
{"from": "EJ", "to": "XA", "cost": 4.78513105653508}
{"from": "OD", "to": "VN", "cost": 8.749074968108324}
{"from": "OD", "to": "UN", "cost": 8.353916539938623}
{"from": "OD", "to": "GL", "cost": 3.9565816235958717}
{"from": "OD", "to": "JA", "cost": 2.272703004948111}
{"from": "OD", "to": "GT", "cost": 0.8064995284036736}
{"from": "OD", "to": "XA", "cost": 8.647393763874543}
{"from": "TI", "to": "UN", "cost": 9.870046899815323}
{"from": "TI", "to": "NM", "cost": 6.675835954232295}
{"from": "TI", "to": "JA", "cost": 3.045271596568606}
{"from": "TI", "to": "GT", "cost": 5.133719202344356}
{"from": "VN", "to": "GL", "cost": 5.096022803356885}
{"from": "VN", "to": "NM", "cost": 6.772055712342516}
{"from": "VN", "to": "XA", "cost": 7.8396910281434895}
{"from": "UN", "to": "GL", "cost": 4.342224840950307}
{"from": "UN", "to": "NM", "cost": 3.9510319091911494}
{"from": "UN", "to": "GT", "cost": 5.5309874488261}
{"from": "GL", "to": "JA", "cost": 7.4205626147744415}
{"from": "GL", "to": "GT", "cost": 2.4108342303709107}
{"from": "NM", "to": "JA", "cost": 7.284673070064656}
{"from": "NM", "to": "GT", "cost": 5.9638369473546025}
{"from": "GT", "to": "XA", "cost": 7.538145282158746}
*/
