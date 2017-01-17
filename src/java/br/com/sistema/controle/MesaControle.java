/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controle;

import br.com.sistema.dao.MesaDao;
import br.com.sistema.dao.MesaDaoImp;
import br.com.sistema.entidade.Mesa;
import java.util.ArrayList;
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
public class MesaControle {

    private Mesa mesa;
    private List<Mesa> mesas;
    private DataModel model;
    private MesaDao mdao;

    public Mesa getMesa() {
        if (mesa == null) {
            mesa = new Mesa();
        }
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }

    public String salvar() {
        mdao = new MesaDaoImp();

        FacesContext context = FacesContext.getCurrentInstance();

        if (mesa.getId() == null) {
            mdao.salva(mesa);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Mesa Salva Com Sucesso!", ""));
        } else {
            mdao.altera(mesa);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Mesa Alterado Com Sucesso!", ""));
        }
        limpar();
        return "";
    }

    public void pesquisa() {
        mesas = new ArrayList<Mesa>();
        mdao = new MesaDaoImp();
        
        if (mesa.getNumero().equals("")) {
        mesas = mdao.getTodos();    

            if (mesas.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Não possui mesa!"));
                limpar();
            } else {
                model = new ListDataModel(mesas);

            }
        } else {
            
            mesa = mdao.buscarMesa(mesa.getNumero());
                mesas.add(mesa);
                model = new ListDataModel(mesas);
                
            if (mesas == null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Mesa inesistente!"));
                limpar();
            } 
        }

    }

    private void limpar() {
        mesa = null;
        mesas = null;
        model = null;
    }

    public String novo() {
        mesa = new Mesa();
        return "cadMesa.faces";
    }

    public String limpaPesquisa() {
        limpar();
        return "pesqMesa";
    }
}
