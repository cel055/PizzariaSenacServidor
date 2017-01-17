/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Mesa;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class MesaDaoImpTest {
    
    public MesaDaoImpTest() {
    }

    
    //@Test
    public void testGetTodos() {
        System.out.println("getTodos");
        MesaDaoImp instance = new MesaDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        MesaDaoImp instance = new MesaDaoImp();
        Mesa expResult = null;
        Mesa result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    //@Test
    public void salvar() {
        System.out.println("salvar");
        
        MesaDao instance = new MesaDaoImp();
        Mesa mesa = new Mesa();
        mesa.setNumero("1");
        mesa.setDisponivel(true);
        instance.salva(mesa);
        
    }
    
    @Test
    public void alterar() {
        System.out.println("alterado");
        
        MesaDao instance = new MesaDaoImp();
        Mesa mesa = new Mesa();
        mesa.setNumero("2");
        mesa.setId(1L);
        mesa.setDisponivel(true);
        instance.altera(mesa);
        
    }
}
