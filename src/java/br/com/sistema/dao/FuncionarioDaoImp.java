/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Funcionario;
import br.com.sistema.util.FabricaSessao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class FuncionarioDaoImp extends BaseDaoImp<Funcionario, Long> implements FuncionarioDao{

    @Override
    public Funcionario pesquisaPorId(Long id) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Funcionario funcionario = (Funcionario) session.get(Funcionario.class, id);
        session.close();
        return funcionario;
    }

    @Override
    public List<Funcionario> getTodos() {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Funcionario");
        List<Funcionario> funcionarios = query.list();
        session.close();
        return funcionarios;
    }

    @Override
    public List<Funcionario> pesquisaLikeNome(String nome) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Funcionario f WHERE f.nome like :valor");
        query.setString("valor", "%" + nome + "%");
        List<Funcionario> funcionarios = query.list();
        session.close();
        return funcionarios;
    }
    
}
