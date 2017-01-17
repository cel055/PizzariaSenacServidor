/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.IngredientePizza;
import br.com.sistema.entidade.PratoQuente;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class IngredientePizzaDaoImpTest {
    
    public IngredientePizzaDaoImpTest() {
    }

//    @Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        IngredientePizzaDaoImp instance = new IngredientePizzaDaoImp();
        IngredientePizza expResult = null;
        IngredientePizza result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testGetTodos() {
        System.out.println("getTodos");
        IngredientePizzaDaoImp instance = new IngredientePizzaDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testPesquisaLikeNome() {
        System.out.println("pesquisaLikeNome");
        String nome = "";
        IngredientePizzaDaoImp instance = new IngredientePizzaDaoImp();
        List expResult = null;
        List result = instance.pesquisaLikeNome(nome);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
