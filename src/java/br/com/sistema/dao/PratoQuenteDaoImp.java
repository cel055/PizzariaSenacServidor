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
public class PratoQuenteDaoImp extends BaseDaoImp<PratoQuente, Long> implements PratoQuenteDao{

    @Override
    public PratoQuente pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PratoQuente> getTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PratoQuente> pesquisaLikeNome(String nome) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM PratoQuente p WHERE p.nome like :valor");
        query.setString("valor", "%" + nome + "%");
        List<PratoQuente> pratoQuentes = query.list();
        session.close();
        return pratoQuentes;
    }

    @Override
    public PratoQuente buscarIngredientesPizza(PratoQuente pratoQuente) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM PratoQuente p  WHERE p.id = :valor ");
        query.setLong("valor", pratoQuente.getId());
        PratoQuente pq = (PratoQuente) query.uniqueResult();
        session.close();
        return pq;
    }
    
}
