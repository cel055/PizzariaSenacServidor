/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.IngredientePizza;
import br.com.sistema.entidade.PratoQuente;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Aluno
 */
public class PratoQuenteDaoImpTest {

//    @Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        PratoQuenteDaoImp instance = new PratoQuenteDaoImp();
        PratoQuente expResult = null;
        PratoQuente result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testGetTodos() {
        System.out.println("getTodos");
        PratoQuenteDaoImp instance = new PratoQuenteDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public PratoQuente testSalva(){
        System.out.println("salva");
        IngredienteDaoImpTest ingredienteDaoImpTest = new IngredienteDaoImpTest();
        PratoQuente pratoQuente = new PratoQuente();
        PratoQuenteDao dao = new PratoQuenteDaoImp();
        pratoQuente.setNome("mussarela");
        IngredientePizza ingrediente1 = ingredienteDaoImpTest.testSalva();
        IngredientePizza ingrediente3 = new IngredientePizza();
        ingrediente3.setId(ingrediente1.getId());
        IngredientePizza ingrediente2 = ingredienteDaoImpTest.testSalva();
        IngredientePizza ingrediente4 = new IngredientePizza();
        ingrediente4.setId(ingrediente2.getId());
        List<IngredientePizza> ingredientes = new ArrayList<IngredientePizza>();
        ingredientes.add(ingrediente3);
        ingredientes.add(ingrediente4);
        pratoQuente.setIngredientes(ingredientes);
        PratoQuente result = dao.salva(pratoQuente);
        assertNotNull(result);
        return result;
    }
}
