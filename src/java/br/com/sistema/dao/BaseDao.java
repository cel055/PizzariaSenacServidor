/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import java.util.List;

/**
 *
 * @author Aluno
 */
public interface BaseDao <T, ID>{
    T salva(T entidade);
    
    T pesquisaPorId(ID id);
    
    void remove(T entidade);
    
    T altera(T entidade);
    
    List<T> getTodos();
}
