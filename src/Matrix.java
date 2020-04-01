import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private int[][] adjMatrix;
    private List<Integer> nodes;
    private int size;


    public void initialize(String filename){

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String string = br.readLine();
            int n = Integer.parseInt(string);
            if(adjMatrix == null){
                this.size = n;
                adjMatrix = new int[n][n];
            }
            nodes = new ArrayList<>(size);
            for(int i=0;i<n;i++){
                nodes.add(i+1);
                String[] costs = br.readLine().split(",");

                for(int j=0;j<n;j++) {
                    if (i == j) {
                        adjMatrix[i][j] = 0;
                    } else {

                        adjMatrix[i][j] = Integer.parseInt(costs[j]);
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Integer pathLength(List<Integer> path){

        int length = 0;
        for(int i =0;i< path.size()-1;i++){

            length += adjMatrix[path.get(i)-1][path.get(i+1)-1];
        }
        //length += adjMatrix[path.get(path.size()-1)-1][path.get(0)-1];

        return length;
    }

    public List<Integer> getNodes() {
        return nodes;
    }

    public int getSize() {
        return size;
    }


}
