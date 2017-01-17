/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Fornecedor;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class FornecedorDaoImpTest {
    
    public FornecedorDaoImpTest() {
    }

    @Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        FornecedorDaoImp instance = new FornecedorDaoImp();
        Fornecedor expResult = null;
        Fornecedor result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTodos() {
        System.out.println("getTodos");
        FornecedorDaoImp instance = new FornecedorDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
