/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.PratoQuente;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface PratoQuenteDao extends BaseDao<PratoQuente, Long> {

    public List<PratoQuente> pesquisaLikeNome(String nome);

    public PratoQuente buscarIngredientesPizza(PratoQuente pratoQuente);
}
