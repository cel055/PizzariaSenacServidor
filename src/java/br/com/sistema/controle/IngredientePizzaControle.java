/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.FornecedorDao;
import br.com.sistema.dao.FornecedorDaoImp;
import br.com.sistema.dao.IngredientePizzaDao;
import br.com.sistema.dao.IngredientePizzaDaoImp;
import br.com.sistema.entidade.Fornecedor;
import br.com.sistema.entidade.IngredientePizza;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class IngredientePizzaControle {
    private IngredientePizza ingredientePizza;
    private Fornecedor fornecedor;
    private IngredientePizzaDao dao;
    private List<IngredientePizza> ingredientePizzas;
    private DataModel model; 

    public DataModel getModel() {
        if (model == null) {
            model = new ArrayDataModel();
        }
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    public IngredientePizza getIngredientePizza() {
        if (ingredientePizza == null) {
            ingredientePizza = new IngredientePizza();
        }
        return ingredientePizza;
    }

    public void setIngredientePizza(IngredientePizza ingredientePizza) {
        this.ingredientePizza = ingredientePizza;
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
        ingredientePizza = null;
        fornecedor = null;
    }
    
    public String novo(){
        ingredientePizza = new IngredientePizza();
        ingredientePizza.setFornecedor(new Fornecedor());
        ingredientePizza.getFornecedor().setNome("");
        return "cadIngredientePizza";
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
        ingredientePizza.setFornecedor(fornecedor);
        dao = new IngredientePizzaDaoImp();
        dao.salva(ingredientePizza);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingrediente Salvo Com Sucesso!", ""));
        limpar();
        return "";
    }
    
    public void pesquisaLike() {
        dao = new IngredientePizzaDaoImp();
        ingredientePizzas = dao.pesquisaLikeNome(ingredientePizza.getNome());
//        listarEnderecos();
       
        if (ingredientePizzas.isEmpty()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Ingrediente inesistente!"));
            limpar();
        } else {
            model = new ListDataModel(ingredientePizzas);

        }
    }
    
    public String limpaPesquisa() {
        limpar();
        return "pesqIngredientePizza";
    }
}
