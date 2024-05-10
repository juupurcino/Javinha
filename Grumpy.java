public class Rabugento extends Individual {
    Boolean taalegrebobao = true;

    @Override
    Boolean colaborate() {
        return taalegrebobao;
    }

    @Override
    void feedback(Boolean result) {
        if (!result)
            taalegrebobao = false;
    }

    @Override
    Individual copy() {
        return new Rabugento();
    }
}