/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Perfil;
import br.com.sistema.util.FabricaSessao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class PerfilDaoImp extends BaseDaoImp<Perfil, Long> implements PerfilDao{

    @Override
    public Perfil pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Perfil> getTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Perfil buscarPerfil(String nome) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Perfil where nomeMenu = :valor");
        query.setString("valor", nome);
        Perfil perfil = (Perfil) query.uniqueResult();
        session.close();
        return perfil;
    }
    
}
