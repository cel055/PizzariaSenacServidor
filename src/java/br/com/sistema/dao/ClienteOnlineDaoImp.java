/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.ClienteOnline;
import br.com.sistema.util.FabricaSessao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class ClienteOnlineDaoImp extends BaseDaoImp<ClienteOnline, Long> implements ClienteOnlineDao{

    @Override
    public ClienteOnline pesquisaPorId(Long id) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        ClienteOnline cliente = (ClienteOnline) session.get(ClienteOnline.class, id);
        session.close();
        return cliente;
    }

    @Override
    public List<ClienteOnline> getTodos() {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM ClienteOnline");
        List<ClienteOnline> clientes = query.list();
        session.close();
        return clientes;
    }
    
    

    @Override
    public List<ClienteOnline> pesquisaLikeNome(String nome) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM ClienteOnline co WHERE co.nome like :valor");
        query.setString("valor", "%" + nome + "%");
        List<ClienteOnline> clientes = query.list();
        session.close();
        return clientes;
    }
    
}
