/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Endereco;
import br.com.sistema.util.FabricaSessao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class EnderecoDaoImp extends BaseDaoImp<Endereco, Long> implements EnderecoDao{

    @Override
    public Endereco pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Endereco> getTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Endereco> buscarEnderecos(Long id) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Endereco WHERE pessoa_id = :valor");
        query.setLong("valor", id);
        List<Endereco> enderecos = query.list();
        session.close();
        return enderecos;
    }
    
}
