/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.EnderecoDao;
import br.com.sistema.dao.EnderecoDaoImp;
import br.com.sistema.dao.PessoaDao;
import br.com.sistema.dao.PessoaDaoImp;
import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mateus
 */
@ManagedBean
@SessionScoped
public class PessoaControle {
    private Pessoa pessoa;
    private Endereco endereco;
    private List<Endereco> enderecos;
    private PessoaDao pdao;

    public Pessoa getPessoa() {
        if (pessoa == null) {
            pessoa = new Pessoa();
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        if (endereco == null) {
            endereco = new Endereco();
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    private void limpar(){
        pessoa = null;
        endereco = null;
        enderecos = null;
        
    }
    public String salvar(){
        pdao = new PessoaDaoImp();
        EnderecoDao edao = new EnderecoDaoImp();
        FacesContext context = FacesContext.getCurrentInstance();
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
        pessoa.setAtivo(false);
        pessoa.setEnderecos(enderecos);
        if (pessoa.getId() == null) {
            
            pessoa = pdao.salva(pessoa);
            for (Endereco end : pessoa.getEnderecos()) {
                end.setPessoa(pessoa);
                edao.salva(end);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa Salvo Com Sucesso!", ""));
        }else{
            pessoa = pdao.altera(pessoa);
            for (Endereco end : pessoa.getEnderecos()) {
                if (end.getId() == null) {
                    end.setPessoa(pessoa);
                    edao.salva(end);
                }else{
                    end.setPessoa(pessoa);
                    edao.altera(end);
                }
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa Alterado Com Sucesso!", ""));
        }
        limpar();
        return "";
    }
    public String novo(){
        pessoa = new Pessoa();
        endereco = new Endereco();
        return "cadClienteTele.faces";
    }
}
