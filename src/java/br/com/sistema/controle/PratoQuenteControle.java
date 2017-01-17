/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.IngredienteDao;
import br.com.sistema.dao.IngredienteDaoImp;
import br.com.sistema.dao.IngredientePizzaDao;
import br.com.sistema.dao.IngredientePizzaDaoImp;
import br.com.sistema.dao.PratoQuenteDao;
import br.com.sistema.dao.PratoQuenteDaoImp;
import br.com.sistema.entidade.Ingrediente;
import br.com.sistema.entidade.IngredientePizza;
import br.com.sistema.entidade.PratoQuente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class PratoQuenteControle{
    private PratoQuente pratoQuente;
    private List<IngredientePizza> ingredientes;
    private Map<String, String> selectItens;
    private List<String> selectedItens;
    private PratoQuenteDao dao;
    private DataModel model;
    private List<PratoQuente> pratoQuentes;
    private Ingrediente ingrediente;

    public Ingrediente getIngrediente() {
        if (ingrediente == null) {
            ingrediente = new Ingrediente();
        }
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<PratoQuente> getPratoQuentes() {
        if (pratoQuentes == null) {
            pratoQuentes = new ArrayList<PratoQuente>();
        }
        return pratoQuentes;
    }

    public void setPratoQuentes(List<PratoQuente> pratoQuentes) {
        this.pratoQuentes = pratoQuentes;
    }

    public DataModel getModel() {
        if (model == null) {
            model = new ArrayDataModel();
        }
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    public PratoQuente getPratoQuente() {
        if (pratoQuente == null) {
            pratoQuente = new PratoQuente();
        }
        return pratoQuente;
    }

    public void setPratoQuente(PratoQuente pratoQuente) {
        this.pratoQuente = pratoQuente;
    }

    public List<IngredientePizza> getIngredientes() {
        if (ingredientes == null) {
            ingredientes = new ArrayList<IngredientePizza>();
        }
        return ingredientes;
    }

    public void setIngredientes(List<IngredientePizza> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Map<String, String> getSelectItens() {
        if (selectItens == null) {
            selectItens = new HashMap<String, String>();
        }
        return selectItens;
    }

    public void setSelectItens(Map<String, String> selectItens) {
        this.selectItens = selectItens;
    }

    public List<String> getSelectedItens() {
        return selectedItens;
    }

    public void setSelectedItens(List<String> selectedItens) {
        this.selectedItens = selectedItens;
    }
    
    private void limpar(){
        ingrediente = null;
        pratoQuente = null;
        ingredientes = null;
        selectItens = null;
        selectedItens = null;
        model = null;
    }
    
    public String novo(){
        pratoQuente = new PratoQuente();
        selectItens = new HashMap<String, String>();
        IngredientePizzaDao pDao = new IngredientePizzaDaoImp();
        ingredientes = pDao.getTodos();
        for (IngredientePizza ingredientePizza : ingredientes) {
            selectItens.put(ingredientePizza.getNome(), ingredientePizza.getId().toString());
        }
        return "cadPratoQuente.faces";
    }
    
    public String salva(){
        ingredientes = new ArrayList<IngredientePizza>();
        for (String itens : selectedItens) {
            IngredientePizza ingredientePizza = new IngredientePizza();
            ingredientePizza.setId(Long.parseLong(itens));
            ingredientes.add(ingredientePizza);
        }
        pratoQuente.setIngredientes(ingredientes);
        dao = new PratoQuenteDaoImp();
        dao.salva(pratoQuente);
        limpar();
        return "";
    }
    
    public String limpaPesquisa() {
        limpar();
        return "pesqPratoQuente";
    }
    
    public void pesquisaLike() {
        dao = new PratoQuenteDaoImp();
        pratoQuentes = dao.pesquisaLikeNome(pratoQuente.getNome());
        List<PratoQuente> pratos = new ArrayList<PratoQuente>();
        if (pratoQuentes.isEmpty()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Prato quente inesistente!"));
            limpar();
        } else {
//            for (PratoQuente pq : pratoQuentes) {
//                pratos.add(dao.buscarIngredientesPizza(pq));
//            }
            model = new ListDataModel(pratoQuentes);
        }

    }
    
}
