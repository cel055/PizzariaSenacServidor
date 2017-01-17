/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.IngredienteBebida;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class IngredienteBebidaDaoImp extends BaseDaoImp<IngredienteBebida, Long> implements IngredienteBebidaDao{

    @Override
    public IngredienteBebida pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IngredienteBebida> getTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
