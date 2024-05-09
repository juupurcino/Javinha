class MaoDeVaca extends Individuo {

    public void MaoDeVacaJogar(){

        if(getMoedas() > 10){
            decidirCooperar();
        }
    }
}