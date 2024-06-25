import java.util.LinkedList;

public class TabelaHash {

    private LinkedList<Integer>[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int hash(int chave) {
        return chave % tamanho;
    }

    public void inserir(int chave) {
        int indice = hash(chave);
        tabela[indice].add(chave);
    }

    public boolean buscar(int chave) {
        int indice = hash(chave);
        return tabela[indice].contains(chave);
    }

    public void remover(int chave) {
        int indice = hash(chave);
        tabela[indice].remove(Integer.valueOf(chave));
    }

    public void mostrarTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            for (Integer elemento : tabela[i]) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        TabelaHash tabela = new TabelaHash(10); 

        tabela.inserir(10);
        tabela.inserir(20);
        tabela.inserir(30);
        tabela.inserir(15);
        tabela.inserir(25);

        tabela.mostrarTabela();
        int busca = 30;
        tabela.buscar(busca);
        int remocao = 20;
        tabela.remover(remocao);
        tabela.mostrarTabela();
    }
}
