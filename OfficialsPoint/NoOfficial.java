// Representa um nó na lista de funcionários
public class NoOfficial {

    // Referência para o próximo nó, inicialmente é null
    private NoOfficial next = null;

    // Valor do nó, que é um funcionário
    private Official value;
    
    // Construtor que inicializa o nó com um funcionário
    NoOfficial(Official value) {
        // Atribui o valor do funcionário passado como parâmetro ao atributo value
        this.value = value;
    }
    
    // Método para obter o próximo nó
    NoOfficial getNext() {
        // Retorna o próximo nó na lista
        return next;
    }
    
    // Método para definir o próximo nó
    void setNext(NoOfficial next) {
        // Define o próximo nó na lista
        this.next = next;
    }
    
    // Método para obter o funcionário armazenado neste nó
    Official getOfficial() {
        // Retorna o funcionário armazenado neste nó
        return value;
    }
}
