package funcaohash;

import java.util.Arrays;

public class FuncaoHash {

    public static int linearSearch(int[] vetor, int n, int x) {
    for (int i = 0; i < n; i++) {
        if (vetor[i] == x) {
            return i;
        }
    }
    return -1;
}

    
    public static int binarySearch(int[] vetor, int inicio, int fim, int x) {
    if (inicio <= fim) {
        int meio = inicio + (fim - inicio) / 2;
        if (vetor[meio] == x) {
            return meio;  
        } else if (vetor[meio] > x) {
            return binarySearch(vetor, inicio, meio - 1, x);  
        } else {
            return binarySearch(vetor, meio + 1, fim, x);  
        }
    }
    return -1;  
}

    public static void main(String[] args) {
    
        int[] vetor = {1, 3, 5, 7, 9};
        int x = 5;

        // Busca Linear
        int resultadoLinear = linearSearch(vetor, vetor.length, x);
        if (resultadoLinear != -1) {
            System.out.println("Elemento encontrado no indice " + resultadoLinear);
        } else {
            System.out.println("Elemento nao encontrado");
        }

        // Busca Binaria
        Arrays.sort(vetor); 
        int resultadoBinario = binarySearch(vetor, 0, vetor.length - 1, x);
        if (resultadoBinario != -1) {
            System.out.println("Elemento encontrado no indice " + resultadoBinario);
        } else {
            System.out.println("Elemento nao encontrado");
        }
    }

}
