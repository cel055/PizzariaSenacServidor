/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Pessoa;
import java.util.List;

/**
 *
 * @author Mateus
 */
public class PessoaDaoImp extends BaseDaoImp<Pessoa, Long> implements PessoaDao{

    @Override
    public Pessoa pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pessoa> getTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
