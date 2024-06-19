// Representa um nó na lista de pontos
public class NoPoint {

    // Referência para o próximo nó, inicialmente é null
    private NoPoint next = null;

    // Valor do nó, que é um ponto
    private Point value;
    
    // Construtor que inicializa o nó com um ponto
    NoPoint(Point value) {
        // Atribui o valor do ponto passado como parâmetro ao atributo value
        this.value = value;
    }
    
    // Método para obter o próximo nó
    NoPoint getNext() {
        // Retorna o próximo nó na lista
        return next;
    }
    
    // Método para definir o próximo nó
    void setNext(NoPoint next) {
        // Define o próximo nó na lista
        this.next = next;
    }
    
    // Método para obter o ponto armazenado neste nó
    Point getPoint() {
        // Retorna o ponto armazenado neste nó
        return value;
    }
}
