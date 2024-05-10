public class Copycat extends Individual {
    private Boolean lastResult = true;

    @Override
    Boolean colaborate() {
        return lastResult;
    }

    @Override
    void feedback(Boolean result) {
        this.lastResult = result;
    }

    @Override
    Individual copy() {
        return new Copycat();
    }
}
