// Lista de pontos
public class ListPoint {
    
    // Primeiro ponto da lista, inicialmente não existe (null)
    private NoPoint head = null;
    // Tamanho da lista, inicialmente é zero
    private int size = 0;

    // Método para adicionar um ponto ao final da lista
    void addPoint(Point point) {
        
        size++; // Incrementa o tamanho da lista
        NoPoint node = new NoPoint(point); // Cria um novo nó com o ponto fornecido
    
        if (head == null) { // Se a lista está vazia
            head = node; // Define o novo nó como o primeiro na lista
            return; // Sai do método
        }
    
        NoPoint tail = head; // Começa do primeiro nó (cabeça da lista)
        while (tail.getNext() != null) { // Enquanto não estiver no último nó
            tail = tail.getNext(); // Avança para o próximo nó
        }
        tail.setNext(node); // Define o novo nó como o próximo do último nó
    }

    // Método para obter o ponto na posição especificada
    Point get(int index) {
        // Começa do primeiro nó
        NoPoint tail = head;

        // Percorre até a posição desejada
        for (int i = 0; i < index; i++) {
            tail = tail.getNext(); // Avança para o próximo nó
        }

        // Retorna o ponto na posição especificada
        return tail.getPoint();
    }
    
    // Método para obter o tamanho atual da lista
    int getSize() {
        return size; // Retorna o número de pontos na lista
    }
} 