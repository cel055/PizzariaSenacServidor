/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Perfil;

/**
 *
 * @author Mateus
 */
public interface PerfilDao extends BaseDao<Perfil, Long>{
    public Perfil buscarPerfil(String nome);
}
