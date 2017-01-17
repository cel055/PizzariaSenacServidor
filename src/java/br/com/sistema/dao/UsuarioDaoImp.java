/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Usuario;
import br.com.sistema.util.FabricaSessao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class UsuarioDaoImp extends BaseDaoImp<Usuario, Long> implements UsuarioDao{

    @Override
    public Usuario pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> getTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario buscarUsuarios(Long id) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Usuario WHERE id = :valor");
        query.setLong("valor", id);
        Usuario usuario = (Usuario) query.uniqueResult();
        session.close();
        return usuario;
    }
    
}
