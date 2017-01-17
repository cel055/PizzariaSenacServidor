/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Usuario;
import java.util.List;

/**
 *
 * @author Mateus
 */
public interface UsuarioDao extends BaseDao<Usuario, Long>{
    Usuario buscarUsuarios(Long id);
}
