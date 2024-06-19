package collections.execeptions;

public class CheckedExeption extends RuntimeException {
    
    private String warning;

    public CheckedExeption(String warning){
        super(warning);
        this.warning = warning;
    }
}
