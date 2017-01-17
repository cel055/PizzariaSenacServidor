/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Ingrediente;
import java.util.List;

/**
 *
 * @author usuario
 */
public class IngredienteDaoImp extends BaseDaoImp<Ingrediente, Long> implements IngredienteDao{

    @Override
    public Ingrediente pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Ingrediente> getTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
