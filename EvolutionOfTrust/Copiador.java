package EvolutionOfTrust;
class Copiador extends Individuo {
    
    private boolean cooperouUltimaRodadaAdversario;

    public void copiadorJogar(boolean adversarioCooperou) {
        if (adversarioCooperou) {
            podeCooperar();
            decidirCooperar();
        } else {
            trapaceou();
        }
        
        cooperouUltimaRodadaAdversario = adversarioCooperou;
    }
}