/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Funcionario;
import java.util.List;

/**
 *
 * @author Mateus
 */
public interface FuncionarioDao extends BaseDao<Funcionario, Long>{
    List<Funcionario> pesquisaLikeNome(String nome);
}
