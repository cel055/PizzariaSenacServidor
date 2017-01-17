/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.FornecedorDao;
import br.com.sistema.dao.FornecedorDaoImp;
import br.com.sistema.dao.IngredienteDao;
import br.com.sistema.dao.IngredienteDaoImp;
import br.com.sistema.entidade.Fornecedor;
import br.com.sistema.entidade.Ingrediente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class IngredienteControle{
    private Ingrediente ingrediente;
    private Fornecedor fornecedor;
    private IngredienteDao dao;    

    public Ingrediente getIngrediente() {
        if (ingrediente == null) {
            ingrediente = new Ingrediente();
        }
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Fornecedor getFornecedor() {
        if (fornecedor == null) {
            fornecedor = new Fornecedor();
        }
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    private void limpar(){
        ingrediente = null;
        fornecedor = null;
    }
    
    public String novo(){
        ingrediente = new Ingrediente();
        ingrediente.setFornecedor(new Fornecedor());
        ingrediente.getFornecedor().setNome("");
        return "cadIngrediente.faces";
    }
    
    public List<SelectItem> getFornecedores(){
        FornecedorDao fornecedorDao = new FornecedorDaoImp();
        List<Fornecedor> fornecedores = fornecedorDao.getTodos();
        List<SelectItem> listaFornecedores = new ArrayList<SelectItem>();
        for (Fornecedor f : fornecedores) {
            listaFornecedores.add(new SelectItem(f.getId(), f.getNome()));
        }
        return listaFornecedores;
    }
    
    public String salva(){
        ingrediente.setFornecedor(fornecedor);
        dao = new IngredienteDaoImp();
        dao.salva(ingrediente);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingrediente Salvo Com Sucesso!", ""));
        limpar();
        return "";
    }
    
}
