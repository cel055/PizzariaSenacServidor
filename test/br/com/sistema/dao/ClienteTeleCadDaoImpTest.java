/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.PessoaFisica;
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
public class ClienteTeleCadDaoImpTest {
    
    public ClienteTeleCadDaoImpTest() {
    }

    //@Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        PessoaFisicaDaoImp instance = new PessoaFisicaDaoImp();
        PessoaFisica expResult = null;
        PessoaFisica result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testGetTodos() {
        System.out.println("getTodos");
        PessoaFisicaDaoImp instance = new PessoaFisicaDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSalva() {
        System.out.println("salva");
        PessoaFisica pessoaFisica = new PessoaFisica();
        Endereco endereco = new Endereco();
        Usuario usuario = new Usuario();
        List<Endereco> enderecos = new ArrayList<Endereco>();
        pessoaFisica.setAtivo(true);
        pessoaFisica.setNome("teste");
        pessoaFisica.setEmail("teste");
        pessoaFisica.setTelefone("teste");
        pessoaFisica.setNascimento("teste");
        pessoaFisica.setInicio(new Date());
        
        endereco.setRua("teste2");
        endereco.setNumero("test2");
        endereco.setComplemento("teste2");
        endereco.setPontoReferencia("teste2");
        endereco.setBairro("teste2");
        endereco.setCidade("teste2");
        enderecos.add(endereco);
        
        usuario.setLogin("teste0101");
        pessoaFisica.setUsuario(usuario);
        
        pessoaFisica.setEnderecos(enderecos);
        PessoaFisicaDao dao = new PessoaFisicaDaoImp();
        PessoaFisica result = dao.salva(pessoaFisica);
        for (Endereco endereco1 : result.getEnderecos()) {
            EnderecoDao edao = new EnderecoDaoImp();
            endereco1.setPessoa(result);
            edao.salva(endereco1);
        }
        assertNotNull(result);
    }

}
