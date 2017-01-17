/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Mesa;
import br.com.sistema.util.FabricaSessao;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mateus
 */
public class MesaDaoImp extends BaseDaoImp<Mesa, Long> implements MesaDao{

    

    @Override
    public List<Mesa> getTodos() {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Mesa");
        List<Mesa> mesas = query.list();
        session.close();
        return mesas;
    }

    @Override
    public Mesa pesquisaPorId(Long id) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Mesa mesa = (Mesa) session.get(Mesa.class, id);
        session.close();
        return mesa;
    }

    @Override
    public List<Mesa> listarMesasDisponíveis() {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Mesa where disponivel = 1");
        List<Mesa> mesas = query.list();
        session.close();
        return mesas;
    }

    @Override
    public Mesa verificarMesa(String numero, Date dia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Mesa buscarMesa(String numero) {
        session = (Session) FabricaSessao.abreConexao().openSession();
        Query query = session.createQuery("FROM Mesa where numero = :valor");
        query.setString("valor", numero);
        Mesa mesa = (Mesa) query.uniqueResult();
        session.close();
        return mesa;
    }

   

   
}

