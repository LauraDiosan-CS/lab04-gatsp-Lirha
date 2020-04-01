import java.util.ArrayList;
import java.util.List;

public class Population {

    private List<Chromosome> population;
    private Integer popSize;

    public Population(Integer popSize, Matrix matrix){

        this.population = new ArrayList<>(popSize);
        this.popSize = popSize;

        for(int i=0; i<this.popSize; i++){
            population.add(new Chromosome(matrix));
        }
    }

    public Population(Population population){
        this.population = population.population;
        this.popSize = population.popSize;
    }

    public Chromosome selection(){

        Chromosome firstSelection = population.get((int)(Math.random()*popSize -1));
        Chromosome secondSelection = population.get((int)(Math.random()*popSize -1));

        if (firstSelection.getFitness() < secondSelection.getFitness()){
            return firstSelection;
        }
        else {
            return secondSelection;
        }
    }

    public Chromosome getTheBest(){

        Chromosome theBest = population.get(0);
        for(Chromosome ch : population){
            if (ch.getFitness() < theBest.getFitness())
                theBest = ch;
        }
        return theBest;
    }

    public void addGeneration(Chromosome generation){

        population.add(generation);
        popSize += 1;
    }
}
