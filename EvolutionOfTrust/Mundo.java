package EvolutionOfTrust;

public class Mundo {

    private Individuo[] individuos; //declara lista de individuos
    private int tamanho; //variavel para tamanho
    public int qtdColaborativo, qtdCopiador, qtdMaoDeVaca, qtdRabugento, qtdTolerante, qtdTrapaceiro;
    
    
    public Mundo(int qtdColaborativo, int qtdCopiador, int qtdRabugento, int qtdTolerante, int qtdTrapaceiro, int qtdMaoDeVaca) {
        
        individuos = new Individuo[500]; //lista de individuos com capacidade 500
        this.tamanho = 0; // variavel de tamanho para controlar a lista
    }

    // declarando classe para adicionar individuos
    public void adicionarIndividuo() {
    
        int index = 0; // variavel para controlar o tamanho
        
        // for p
        for (int i = 0; i < this.qtdColaborativo && index < individuos.length; i++) {
            individuos[index++] = new Colaborativo(); 
            tamanho++;
        }
        for (int i = 0; i < this.qtdCopiador && index < individuos.length; i++) {
            individuos[index++] = new Copiador();
            tamanho++;
        }
        for (int i = 0; i < this.qtdRabugento && index < individuos.length; i++) {
            individuos[index++] = new Rabugento();
            tamanho++;
        }
        for (int i = 0; i < this.qtdTolerante && index < individuos.length; i++) {
            individuos[index++] = new Tolerante();
            tamanho++;
        }
        for (int i = 0; i < this.qtdTrapaceiro && index < individuos.length; i++) {
            individuos[index++] = new Trapaceiro();
            tamanho++;
        }
        for (int i = 0; i < this.qtdMaoDeVaca && index < individuos.length; i++) {
            individuos[index++] = new MaoDeVaca();
            tamanho++;
        }
        
        verificarDuplicarMoedas();
    }

    
    public void realizarInteracoes() {
        
        Individuo[] individuos =  ;
        for (int i = 0; i < tamanho; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                Individuo jogador1 = individuos[i];
                Individuo jogador2 = individuos[j];
                
                //Os dois cooperam
                if (jogador1.podeCooperar() && jogador2.podeCooperar()) {
                    jogador1.decidirCooperar();
                    jogador2.decidirCooperar();
                    jogador1.setMoedas(jogador1.getMoedas() + 2);
                    jogador2.setMoedas(jogador2.getMoedas() + 2);
                }
                // Um jogador coopera e o outro trapaceia
                else if (jogador1.podeCooperar() && !jogador2.podeCooperar()) {
                    jogador1.decidirCooperar();
                    jogador2.trapaceou();
                    jogador2.setMoedas(jogador2.getMoedas() + 4);
                }
                else if (!jogador1.podeCooperar() && jogador2.podeCooperar()) {
                    jogador1.trapaceou();
                    jogador2.decidirCooperar();
                    jogador1.setMoedas(jogador1.getMoedas() + 4);
                }
            }
        }
    }
}

        
        // public void adicionarIndividuo(Individuo individuo) {
        //     if (tamanho < individuos.length) {
        //         individuos[tamanho] = individuo;
        //         tamanho++;
        //     }
            
        //     verificarDuplicarMoedas();
        // }
        
        private void verificarDuplicarMoedas() {
            
            for (int i = 0; i < tamanho; i++) {
                Individuo individuo = individuos[i];
                if (individuo.getMoedas() >= 20) {
                    individuo.setMoedas(individuo.getMoedas() / 2);
    
                }
            }
        }
        
        public void removerIndividuo(Individuo individuo){
            if(podeCooperar() == false){
                
            }
        } 
        
        public Individuo[] getIndividuos() {
            return individuos;
        }
        
        public void setIndividuos(Individuo[] individuos) {
            this.individuos = individuos;
        }
        
        public int getTamanho() {
            return tamanho;
        }
        
        public void setTamanho(int tamanho) {
            this.tamanho = tamanho;
        }
        
    }