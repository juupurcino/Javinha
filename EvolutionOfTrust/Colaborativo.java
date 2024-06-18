package EvolutionOfTrust;
class Colaborativo extends Individuo {

    public void colaborativoJogar() {
        
        if (podeCooperar()) { // se tiver pelo menos 1 moeda (herdando da classe Individuo)
            decidirCooperar(); //ele coopera se tiver o requisito
        }
    }
}


