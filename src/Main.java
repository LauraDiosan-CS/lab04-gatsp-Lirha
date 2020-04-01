public class Main {

    public static void main(String[] args) {

        EvolutiveAlgorithm graph = new EvolutiveAlgorithm("/Users/lisa/Desktop/Lab4/src/files/medium_01_tsp.txt");
        graph.TSP(500,500, "/Users/lisa/Desktop/Lab4/src/files/medium_out.txt");
    }
}
