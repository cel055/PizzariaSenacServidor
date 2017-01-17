/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.EnderecoDao;
import br.com.sistema.dao.EnderecoDaoImp;
import br.com.sistema.dao.FuncionarioDao;
import br.com.sistema.dao.FuncionarioDaoImp;
import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.Funcionario;
import br.com.sistema.entidade.Usuario;
import br.com.sistema.util.GeraPerfil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Mateus
 */
@ManagedBean
@SessionScoped
public class FuncionarioControle {
    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private Endereco endereco;
    private List<Endereco> enderecos;
    private Usuario usuario;
    private FuncionarioDao fdao;
    private DataModel model;

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String salvar(){
        fdao = new FuncionarioDaoImp();
        EnderecoDao edao = new EnderecoDaoImp();
        FacesContext context = FacesContext.getCurrentInstance();
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
        funcionario.setEnderecos(enderecos);
        funcionario.setUsuario(usuario);
        funcionario.setInicio(new Date());
        if (funcionario.getId() == null) {
            funcionario.setAtivo(true);
//            funcionario.getUsuario().setPerfils(GeraPerfil.perfis(funcionario));
            funcionario = fdao.salva(funcionario);
            for (Endereco end : funcionario.getEnderecos()) {
                end.setPessoa(funcionario);
                edao.salva(end);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionario Salvo Com Sucesso!", ""));
        }else{
            funcionario = fdao.altera(funcionario);
            for (Endereco end : funcionario.getEnderecos()) {
                if (end.getId() == null) {
                    end.setPessoa(funcionario);
                    edao.salva(end);
                }else{
                    end.setPessoa(funcionario);
                    edao.altera(end);
                }
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionario Alterado Com Sucesso!", ""));
        }
        limpar();
        return "";
    }
    
    private void limpar(){
        funcionario = null;
        endereco = null;
        usuario = null;
        enderecos = null;
        model = null;
    }
    
    public void pesquisaLike() {
        fdao = new FuncionarioDaoImp();
        funcionarios = fdao.pesquisaLikeNome(funcionario.getNome());
        listarEnderecos();
       
        if (funcionarios.isEmpty()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Funcionario inesistente!"));
            limpar();
        } else {
            model = new ListDataModel(funcionarios);

        }
    }

    public void listarEnderecos() {
        EnderecoDao edao = new EnderecoDaoImp();
        List<Endereco> ends = new ArrayList<Endereco>();
        for (Funcionario func : funcionarios) {
            ends = edao.buscarEnderecos(func.getId());
            func.setEnderecos(ends);

        }
    }
    
    public String novo(){
        funcionario = new Funcionario();
        funcionario.setUsuario(new Usuario());
        endereco = new Endereco();
        return "cadFuncionario.faces";
    }
    public String limpaPesquisa() {
        limpar();
        return "pesqFuncionario";
    }
}
