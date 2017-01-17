/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Mesa;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mateus
 */
public interface MesaDao extends BaseDao<Mesa, Long>{
    
    List<Mesa> listarMesasDisponíveis();
    Mesa verificarMesa(String numero, Date dia);
    Mesa buscarMesa(String numero);
}
