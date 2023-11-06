package payroll;

public class FuncionarioNotFoundException extends  RuntimeException{
    public FuncionarioNotFoundException(Long id) {
        super("Could not find employee " + id);

    }
}
