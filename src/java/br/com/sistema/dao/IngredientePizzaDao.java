/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.IngredientePizza;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface IngredientePizzaDao extends BaseDao<IngredientePizza, Long> {
    public List<IngredientePizza>pesquisaLikeNome(String nome);
}
