import java.util.Random;

public class Matematico extends Individual {
    Random random = new Random(System.nanoTime());

    @Override
    Boolean colaborate() {
        return random.nextInt(100) < 75;
    }

    @Override
    void feedback(Boolean result) { }

    @Override
    Individual copy() {
        return new Matematico();
    }
}
