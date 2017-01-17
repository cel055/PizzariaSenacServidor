/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Endereco;
import java.util.List;

/**
 *
 * @author Mateus
 */
public interface EnderecoDao extends BaseDao<Endereco, Long>{
    List<Endereco> buscarEnderecos(Long id);
}
