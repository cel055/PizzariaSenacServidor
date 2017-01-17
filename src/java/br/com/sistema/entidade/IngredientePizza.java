/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.entidade;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author CamposCosta
 */
@Entity
public class IngredientePizza extends Ingrediente{
    
    @ManyToMany
    @JoinTable(name="ingredPratoQuente", joinColumns=@JoinColumn(name="id_ingredientePizza"), inverseJoinColumns=@JoinColumn(name="id_pratoQuente"))
    private List<PratoQuente> pratosQuentes;

    public List<PratoQuente> getPratosQuentes() {
        return pratosQuentes;
    }

    public void setPratosQuentes(List<PratoQuente> pratosQuentes) {
        this.pratosQuentes = pratosQuentes;
    }
    
}
