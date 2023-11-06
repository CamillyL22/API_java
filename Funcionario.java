package payroll;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
class Funcionario{

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String funcao;

    Funcionario() {}

    Funcionario(String nome, String funcao) {

        this.nome = nome;
        this.funcao = funcao;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Funcionario))
            return false;
        Funcionario funcionario = (Funcionario) o;
        return Objects.equals(this.id, funcionario.id) && Objects.equals(this.nome, funcionario.nome)
                && Objects.equals(this.funcao, funcionario.funcao);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.nome, this.funcao);
    }

    public String toString() {
        return "Funcionario{" + "id=" + this.id + ", nome='" + this.nome + '\'' + ", função='" + this.funcao + '\'' + '}';
    }
}