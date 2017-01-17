/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.PessoaJuridica;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface PessoaJuridicaDao extends BaseDao<PessoaJuridica, Long> {
    public List<PessoaJuridica> pesquisaLikeNome(String nome);
}
