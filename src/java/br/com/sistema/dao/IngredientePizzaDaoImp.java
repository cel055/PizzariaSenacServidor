/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.IngredientePizza;
import br.com.sistema.entidade.PratoQuente;
import br.com.sistema.util.FabricaSessao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aluno
 */
public class IngredientePizzaDaoImp extends BaseDaoImp<IngredientePizza, Long> implements IngredientePizzaDao{

    @Override
    public IngredientePizza pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IngredientePizza> getTodos() {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM IngredientePizza i");
        List<IngredientePizza> ingredientePizzas = query.list();
        session.close();
        return ingredientePizzas;
    }

    @Override
    public List<IngredientePizza> pesquisaLikeNome(String nome) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM IngredientePizza i WHERE i.nome like :valor");
        query.setString("valor", "%" + nome + "%");
        List<IngredientePizza> ingredientePizzas = query.list();
        session.close();
        return ingredientePizzas;
    }   
    
}
