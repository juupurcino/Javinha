package EvolutionOfTrust;
public class Individuo {
    
    private int moedas;
    
    public int getMoedas() {
        return moedas;
    }


    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    private int maquina;
    
    public Individuo() {
        this.moedas = 10;
        this.maquina = 0;
    }


    public void decidirCooperar() {
        int valor = 1;
        maquina += valor;
        moedas -= valor;
    }
    
    public boolean podeCooperar() {
        return moedas >= 1; 
    }

    public boolean trapaceou() {
        moedas =+ 4;
        return maquina == 0;
    }
}

