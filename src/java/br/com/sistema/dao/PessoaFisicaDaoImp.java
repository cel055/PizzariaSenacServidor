/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.PessoaFisica;
import java.util.List;

/**
 *
 * @author Mateus
 */
public class PessoaFisicaDaoImp extends BaseDaoImp<PessoaFisica, Long> implements PessoaFisicaDao{

    @Override
    public PessoaFisica pesquisaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PessoaFisica> getTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
