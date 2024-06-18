package EvolutionOfTrust;
class Tolerante extends Individuo {
    
    private int vezesTrapaceado;

    public void toleranteJogar() {
        if (vezesTrapaceado < 3) {
            podeCooperar();
            decidirCooperar();
        } else {
            trapaceou();
        }
    }

    // atualizar o contador de vezes que foi trapaceado
    public void atualizarVezesTrapaceado() {
        vezesTrapaceado++;
    }

    //  reiniciar o contador de vezes que foi trapaceado
    public void reiniciarVezesTrapaceado() {
        vezesTrapaceado = 0;
    }
}