public class Cheater extends Individual {
    @Override
    Boolean colaborate() {
        return false;
    }

    @Override
    void feedback(Boolean result) { }

    @Override
    Individual copy() {
        return new Cheater();
    }
}
