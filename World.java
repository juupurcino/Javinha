import java.util.ArrayList;
import java.util.Random;

class World
{
    private Random random;
    private Integer initialCoins;
    private Integer taxCoins;
    private Integer unluckyChance;
    private Integer unluckyDamage;
    private Integer collaborateGain;
    private Integer cheatGain;

    World(
        Integer initialCoins, Integer taxCoins,
        Integer unluckyChance, Integer unluckyDamage,
        Integer collaborateGain, Integer cheatGain
    ) {
        this.random = new Random(
            System.currentTimeMillis()
        );
        this.initialCoins = initialCoins;
        this.taxCoins = taxCoins;
        this.unluckyChance = unluckyChance;
        this.unluckyDamage = unluckyDamage;
        this.collaborateGain = collaborateGain;
        this.cheatGain = cheatGain;
    }
    
    private ArrayList<Individual> population = new ArrayList<>();
    void add(Individual individual) {
        individual.setCoins(initialCoins);
        this.population.add(individual);
    }

    Boolean isEnded() {
        return population.size() < 2;
    }

    void makeRound(Integer rounds) {
        for (int i = 0; i < rounds; i++)
            makeRound();
    }

    void makeRound() {
        int N = population.size() / 2;
        for (int i = 0; i < N; i++) {
            int p = random.nextInt(population.size());
            int q = (p + 1 + random.nextInt(population.size() - 1)) 
                % population.size();
            
            Individual indA = population.get(p);
            Individual indB = population.get(q);

            Boolean collaborateA = indA.colaborate();
            Boolean collaborateB = indB.colaborate();

            indA.feedback(collaborateB);
            indB.feedback(collaborateA);

            if (collaborateA && collaborateB) {
                indA.addCoins(collaborateGain - 1);
                indB.addCoins(collaborateGain - 1);
            }
            else if (collaborateA) {
                indA.addCoins(-1);
                indB.addCoins(cheatGain);
            }
            else if (collaborateB) {
                indA.addCoins(cheatGain);
                indB.addCoins(-1);
            }
        }

        for (int i = 0; i < population.size(); i++) {
            Individual ind = population.get(i);
            ind.addCoins(-taxCoins);

            if (random.nextInt(100) > unluckyChance)
                continue;
            ind.addCoins(-unluckyDamage);
        }

        for (int i = 0; i < population.size(); i++) {
            Individual ind = population.get(i);
            if (ind.getCoins() > 0)
                continue;
            
            population.remove(ind);
            i--;
        }

        for (int i = 0; i < population.size(); i++) {
            Individual ind = population.get(i);
            if (ind.getCoins() <= 20)
                continue;
            
            ind.addCoins(-10);
            Individual clone = ind.copy();
            clone.setCoins(10);
            population.add(clone);
        }
    }

    @Override
    public String toString() {
        return "World { population = " + population.size() + " }";  
    }
}
