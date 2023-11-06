package payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}