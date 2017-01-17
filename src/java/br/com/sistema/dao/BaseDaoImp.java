/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.sistema.util.FabricaSessao;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aluno
 */
public abstract class BaseDaoImp <T, ID> implements BaseDao<T, ID> {
    protected Session session;
    protected Transaction transaction;
    
    @Override
    public T salva(T entidade){
        abreSessao();
        session.save(entidade);
        fechaSessao();
        return entidade;
    }
    
    @Override
    public T altera(T entidade){
        abreSessao();
        session.update(entidade);
        fechaSessao();
        return entidade;
    }
    
    @Override
    public void remove(T entidade){
        abreSessao();
        session.delete(entidade);
        fechaSessao();
    }
    
    protected void abreSessao() {
        SessionFactory sf = FabricaSessao.abreConexao();
        session = sf.openSession();
        transaction = session.beginTransaction();
    }
    
    protected void fechaSessao(){
        transaction.commit();
        session.close();
    }
}
