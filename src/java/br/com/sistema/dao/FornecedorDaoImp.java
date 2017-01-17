/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Fornecedor;
import br.com.sistema.util.FabricaSessao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class FornecedorDaoImp extends BaseDaoImp<Fornecedor, Long> implements FornecedorDao{

    @Override
    public Fornecedor pesquisaPorId(Long id) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Fornecedor fornecedor = (Fornecedor) session.get(Fornecedor.class, id);
        session.close();
        return fornecedor;
    }

    @Override
    public List<Fornecedor> getTodos() {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Fornecedor f");
        List<Fornecedor> fornecedores = query.list();
        session.close();
        return fornecedores;
    }

    @Override
    public List<Fornecedor> pesquisaLikeNome(String nome) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Fornecedor f WHERE f.nome like :valor");
        query.setString("valor", "%" + nome + "%");
        List<Fornecedor> fornecedores = query.list();
        session.close();
        return fornecedores;
    }
    
}
