/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.ClienteOnline;
import java.util.List;

/**
 *
 * @author Mateus
 */
public interface ClienteOnlineDao extends BaseDao<ClienteOnline, Long>{
    List<ClienteOnline> pesquisaLikeNome(String nome);
}
