/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.PessoaJuridica;
import br.com.sistema.util.FabricaSessao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class PessoaJuridicaDaoImp extends BaseDaoImp<PessoaJuridica, Long> implements PessoaJuridicaDao {

    @Override
    public PessoaJuridica pesquisaPorId(Long id) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        PessoaJuridica pessoaFisica = (PessoaJuridica) session.get(PessoaJuridica.class, id);
        session.close();
        return pessoaFisica;
    }

    @Override
    public List<PessoaJuridica> getTodos() {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM PessoaJuridica j");
        List<PessoaJuridica> pessoaFisicas = query.list();
        session.close();
        return pessoaFisicas;
    }

    @Override
    public List<PessoaJuridica> pesquisaLikeNome(String nome) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM PessoaJuridica j WHERE j.nome like :valor");
        query.setString("valor", "%" + nome + "%");
        List<PessoaJuridica> pessoaJuridicas = query.list();
        session.close();
        return pessoaJuridicas;
    }
}
