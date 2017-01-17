/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Fornecedor;
import br.com.sistema.entidade.Ingrediente;
import br.com.sistema.entidade.IngredientePizza;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class IngredienteDaoImpTest {

//    @Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        IngredienteDaoImp instance = new IngredienteDaoImp();
        Ingrediente expResult = null;
        Ingrediente result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testGetTodos() {
        System.out.println("getTodos");
        IngredienteDaoImp instance = new IngredienteDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public IngredientePizza testSalva(){
        System.out.println("salva");
        PessoaFisicaDaoImpTest pImpTest = new PessoaFisicaDaoImpTest();
        IngredientePizza ingrediente = new IngredientePizza();
        IngredientePizzaDao dao = new IngredientePizzaDaoImp();
        ingrediente.setNome("ingred");
        ingrediente.setQuantidade(2);
        ingrediente.setValorCompra(null);
        Fornecedor fornecedor = pImpTest.testSalva();
//        ingrediente.setFornecedor(pImpTest.testSalva());
        ingrediente.setFornecedor(fornecedor);
        IngredientePizza result = dao.salva(ingrediente);
        assertNotNull(result);
        return result;
    }
}
