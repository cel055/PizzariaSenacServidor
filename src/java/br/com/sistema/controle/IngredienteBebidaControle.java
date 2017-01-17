/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.FornecedorDao;
import br.com.sistema.dao.FornecedorDaoImp;
import br.com.sistema.dao.IngredienteBebidaDao;
import br.com.sistema.dao.IngredienteBebidaDaoImp;
import br.com.sistema.entidade.Fornecedor;
import br.com.sistema.entidade.IngredienteBebida;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class IngredienteBebidaControle {
    private IngredienteBebida ingredienteBebida;
    private Fornecedor fornecedor;
    private IngredienteBebidaDao dao;

    public IngredienteBebida getIngredienteBebida() {
        if (ingredienteBebida == null) {
            ingredienteBebida = new IngredienteBebida();
        }
        return ingredienteBebida;
    }

    public void setIngredienteBebida(IngredienteBebida ingredienteBebida) {
        this.ingredienteBebida = ingredienteBebida;
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
    
    public void limpar(){
        ingredienteBebida = null;
        fornecedor = null;
    }
    
    public String novo(){
        ingredienteBebida = new IngredienteBebida();
        ingredienteBebida.setFornecedor(new Fornecedor());
        ingredienteBebida.getFornecedor().setNome("");
        return "cadIngredienteBebida";
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
        ingredienteBebida.setFornecedor(fornecedor);
        dao = new IngredienteBebidaDaoImp();
        dao.salva(ingredienteBebida);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingrediente Salvo Com Sucesso!", ""));
        limpar();
        return "";
    }
    
}
