/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Fornecedor;
import java.util.List;

/**
 *
 * @author Mateus
 */
public interface FornecedorDao extends BaseDao<Fornecedor, Long> {
        
    List<Fornecedor> pesquisaLikeNome(String nome);
}
