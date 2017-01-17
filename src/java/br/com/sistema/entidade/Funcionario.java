/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.entidade;


import javax.persistence.Column;
import javax.persistence.Entity;


/**
 *
 * @author Mateus
 */
@Entity
public class Funcionario extends PessoaFisica {
    
    @Column(length=20, nullable=false)
    private String rg;
    @Column(length=15, nullable=false)
    private String cpf;
    @Column(precision=5, scale=2)
    private Float salario;
    @Column(length=13, nullable=false)
    private String funcao;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    
    
    
}
