/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.ClienteOnline;
import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class ClienteOnlineDaoImpTest {
    
    public ClienteOnlineDaoImpTest() {
    }

    //@Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        ClienteOnlineDaoImp instance = new ClienteOnlineDaoImp();
        ClienteOnline expResult = null;
        ClienteOnline result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testGetTodos() {
        System.out.println("getTodos");
        ClienteOnlineDaoImp instance = new ClienteOnlineDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSalva() {
        System.out.println("salva");
        ClienteOnline cliente = new ClienteOnline();
        Endereco endereco = new Endereco();
        Usuario usu = new Usuario();
        
        List<Endereco> enderecos = new ArrayList<Endereco>();
        cliente.setAtivo(true);
        cliente.setNome("teste3");
        cliente.setEmail("teste3");
        cliente.setTelefone("test3");
        cliente.setNascimento("teste3");
        cliente.setInicio(new Date());
        
        
        usu.setLogin("124");
        
        usu.setLogado(true);
        cliente.setUsuario(usu);
        
        endereco.setRua("test2");
        endereco.setNumero("tes2");
        endereco.setComplemento("test2");
        endereco.setPontoReferencia("test2");
        endereco.setBairro("test2");
        endereco.setCidade("teste2");
        enderecos.add(endereco);
        cliente.setEnderecos(enderecos);
        
        ClienteOnlineDao dao = new ClienteOnlineDaoImp();
        ClienteOnline result = dao.salva(cliente);
        for (Endereco end : result.getEnderecos()) {
            EnderecoDao edao = new EnderecoDaoImp();
            end.setPessoa(result);
            edao.salva(end);
        }
        assertNotNull(result);
    }
}
