/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.ClienteOnlineDao;
import br.com.sistema.dao.ClienteOnlineDaoImp;
import br.com.sistema.dao.EnderecoDao;
import br.com.sistema.dao.EnderecoDaoImp;
import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.dao.UsuarioDaoImp;
import br.com.sistema.entidade.ClienteOnline;
import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.Usuario;
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
public class ClienteOnlineControle {
    private ClienteOnline cliente;
    private Endereco endereco;
    private Usuario usuario;
    private ClienteOnlineDao codao;
    private DataModel model;
    private List<ClienteOnline> clientes;
    private List<Endereco> enderecos;

    public ClienteOnline getCliente() {
        if (cliente == null) {
            cliente = new ClienteOnline();
        }
        return cliente;
    }

    public void setCliente(ClienteOnline cliente) {
        this.cliente = cliente;
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

    public List getEnderecos() {
        if (enderecos == null) {
            enderecos = new ArrayList<Endereco>();
        }
        return enderecos;
    }

    public void setEnderecos(List enderecos) {
        this.enderecos = enderecos;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    public List<ClienteOnline> getClientes() {
        if (clientes == null) {
            clientes = new ArrayList<ClienteOnline>();
        }
        return clientes;
    }

    public void setClientes(List<ClienteOnline> clientes) {
        this.clientes = clientes;
    }
    
    
    
    public String salvar(){
        codao = new ClienteOnlineDaoImp();
        EnderecoDao edao = new EnderecoDaoImp();
        FacesContext context = FacesContext.getCurrentInstance();
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
        cliente.setEnderecos(enderecos);
        cliente.setUsuario(usuario);
        cliente.setInicio(new Date());
        if (cliente.getId() == null) {
            cliente.setAtivo(true);
            cliente = codao.salva(cliente);
            for (Endereco end : cliente.getEnderecos()) {
                end.setPessoa(cliente);
                edao.salva(end);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionario Salvo Com Sucesso!", ""));
        }else{
            cliente = codao.altera(cliente);
            for (Endereco end : cliente.getEnderecos()) {
                if (end.getId() == null) {
                    end.setPessoa(cliente);
                    edao.salva(end);
                }else{
                    end.setPessoa(cliente);
                    edao.altera(end);
                }
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionario Alterado Com Sucesso!", ""));
        }
        limpar();
        return "";
    }
    
    public void pesquisaLike() {
        codao = new ClienteOnlineDaoImp();
        clientes = codao.pesquisaLikeNome(cliente.getNome());
        listarEnderecos();
       
        if (clientes.isEmpty()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Cliente inesistente!"));
            limpar();
        } else {
            model = new ListDataModel(clientes);

        }
    }

    public void listarEnderecos() {
        EnderecoDao edao = new EnderecoDaoImp();
        List<Endereco> ends = new ArrayList<Endereco>();
        for (ClienteOnline co : clientes) {
            ends = edao.buscarEnderecos(co.getId());
            co.setEnderecos(ends);

        }
    }
    
    
    private void limpar(){
        cliente = null;
        endereco = null;
        usuario = null;
        enderecos = null;
        model=null;
    }
    
    public String novo(){
        cliente = new ClienteOnline();
        cliente.setUsuario(new Usuario());
        endereco = new Endereco();
        return "cadClienteOnline.faces";
    }
    
    public String limpaPesquisa() {
        limpar();
        return "pesqClienteOnline";
    }
    
}
