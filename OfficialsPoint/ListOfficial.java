// Lista de funcionários
public class ListOfficial {
    
    // Primeiro funcionário da lista, inicialmente não existe (null)
    private NoOfficial head = null;
    // Tamanho da lista, inicialmente é zero
    private int size = 0;

    // Método para adicionar um oficial ao final da lista
    void add(Official official) {
        
        size++; // Incrementa o tamanho da lista
        NoOfficial node = new NoOfficial(official); // Cria um novo nó com o oficial fornecido
    
        if (head == null) { // Se a lista está vazia
            head = node; // Define o novo nó como o primeiro na lista
            return; // Sai do método
        }
    
        NoOfficial tail = head; // Começa do primeiro nó (cabeça da lista)
        while (tail.getNext() != null) { // Enquanto não estiver no último nó
            tail = tail.getNext(); // Avança para o próximo nó
        }
        tail.setNext(node); // Define o novo nó como o próximo do último nó
    }

    // Método para obter o funcionário na posição especificada
    Official get(int index) {
        // Começa do primeiro nó
        NoOfficial tail = head;

        // Percorre até a posição desejada
        for (int i = 0; i < index; i++) {
            tail = tail.getNext(); // Avança para o próximo nó
        }

        // Retorna o funcionário na posição especificada
        return tail.getOfficial();
    }
    
    // Método para obter o tamanho atual da lista
    int getSize() {
        return size; // Retorna o número de funcionários na lista
    }
}
