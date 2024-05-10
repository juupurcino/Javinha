public class Honesto extends Individual {
    @Override
    Boolean colaborate() {
        return true;
    }

    @Override
    void feedback(Boolean result) { }

    @Override
    Individual copy() {
        return new Honesto();
    }
}