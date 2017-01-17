/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.EnderecoDao;
import br.com.sistema.dao.EnderecoDaoImp;
import br.com.sistema.dao.PessoaFisicaDao;
import br.com.sistema.dao.PessoaFisicaDaoImp;
import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.Pessoa;
import br.com.sistema.entidade.PessoaFisica;
import br.com.sistema.entidade.Usuario;
import java.util.ArrayList;
import java.util.Date;
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
public class ClienteTeleCadastradoControle {
    private PessoaFisica pessoa;
    private Endereco endereco;
    private Usuario usuario;
    private List<Endereco> enderecos;
    private PessoaFisicaDao pfdao;

    public PessoaFisica getPessoa() {
        if (pessoa == null) {
            pessoa = new PessoaFisica();
        }
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
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

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    private void limpar(){
        pessoa = null;
        endereco = null;
        enderecos = null;
        usuario = null;
        
    }
    
    public String salvar(){
        pfdao = new PessoaFisicaDaoImp();
        EnderecoDao edao = new EnderecoDaoImp();
        FacesContext context = FacesContext.getCurrentInstance();
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
        pessoa.setAtivo(false);
        pessoa.setEnderecos(enderecos);
        pessoa.setUsuario(usuario);
        pessoa.setInicio(new Date());
        if (pessoa.getId() == null) {
            
            pessoa = pfdao.salva(pessoa);
            for (Endereco end : pessoa.getEnderecos()) {
                end.setPessoa(pessoa);
                edao.salva(end);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa Salvo Com Sucesso!", ""));
        }else{
            pessoa = pfdao.altera(pessoa);
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
        pessoa = new PessoaFisica();
        pessoa.setUsuario(new Usuario());
        endereco = new Endereco();
        return "cadClienteTeleCadastrado.faces";
    }
}
