/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class PessoaDaoImpTest {
    
    public PessoaDaoImpTest() {
    }

    //@Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        PessoaDaoImp instance = new PessoaDaoImp();
        Pessoa expResult = null;
        Pessoa result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testGetTodos() {
        System.out.println("getTodos");
        PessoaDaoImp instance = new PessoaDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSalvar() {
        
        List<Endereco> enderecos = new ArrayList<Endereco>();
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        pessoa.setTelefone("3232-3232");
        endereco.setRua("avcxs");
        enderecos.add(endereco);
        pessoa.setEnderecos(enderecos);
        pessoa.setAtivo(false);
        PessoaDao dao = new PessoaDaoImp();
        Pessoa result = dao.salva(pessoa);
        for (Endereco end : result.getEnderecos()) {
            EnderecoDao edao = new EnderecoDaoImp();
            end.setPessoa(result);
            edao.salva(end);
        }
        
        assertNotNull(result);
    }
}
