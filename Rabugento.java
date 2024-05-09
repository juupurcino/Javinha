class Rabugento extends Individuo {
    private boolean trapaceouUltimaRodada;

    public void rabugentoJogar() {
        if (trapaceouUltimaRodada) {
            trapaceou();
        } else {
            podeCooperar();
            decidirCooperar();
        }
    }

    public void atualizarTrapaceouUltimaRodada(boolean trapaceou) {
        trapaceouUltimaRodada = trapaceou;
    }
}