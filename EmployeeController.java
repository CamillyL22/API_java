package payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class EmployeeController {

    private final FuncionarioRepository repository;

    EmployeeController(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Funcionario> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    Funcionario newFuncionario (@RequestBody Funcionario newFuncionario) {
        return repository.save(newFuncionario);
    }

    @GetMapping("/employees/{id}")
    Funcionario one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new FuncionarioNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Funcionario replaceEmployee(@RequestBody Funcionario newFuncionario, @PathVariable Long id) {

        return repository.findById(id)
                .map(funcionario -> {
                    funcionario.setNome(newFuncionario.getNome());
                    funcionario.setFuncao(newFuncionario.getFuncao());
                    return repository.save(funcionario);
                })
                .orElseGet(() -> {
                    newFuncionario.setId(id);
                    return repository.save(newFuncionario);
                });
    }

    @DeleteMapping
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}