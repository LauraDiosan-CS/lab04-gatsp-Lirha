import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chromosome {

    private int nodesNr ;
    private List<Integer> generation ;
    private Matrix matrix;
    private int fitness;


    public Chromosome(Matrix matrix)
    {
        this.matrix = matrix;
        this.nodesNr = matrix.getSize();
        this.generation = new ArrayList<>(matrix.getNodes());
        Collections.shuffle(generation);
        this.fitness = calculateFitness();
    }

    public int calculateFitness(){

        return this.matrix.pathLength(generation);
    }

    public Chromosome crossOver(Chromosome other){

        List<Integer> xo = new ArrayList<>(nodesNr);

        for(int i=0; i<nodesNr; i++) {
            xo.add(other.generation.get(this.generation.get(i) - 1));
        }
        Chromosome offspring = new Chromosome(this.matrix);
        offspring.setGeneration(xo);
        offspring.setFitness(offspring.calculateFitness());

        return offspring;
    }

    public Chromosome mutation(){

        int poz1 = (int)(Math.random()*(nodesNr-1)) ;
        int poz2 = (int)(Math.random()*(nodesNr-1)) ;
        Integer aux = generation.get(poz1);
        this.generation.set(poz1,generation.get(poz2));
        // set(index, element)
        this.generation.set(poz2,aux);

        return this;
    }

    public List<Integer> getGeneration() {
        return generation;
    }

    public void setGeneration(List<Integer> generation) {
        this.generation = generation;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
}
