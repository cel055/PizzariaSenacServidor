/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.Funcionario;
import br.com.sistema.entidade.Perfil;
import br.com.sistema.entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class FuncionarioDaoImpTest {

    //@Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        FuncionarioDaoImp instance = new FuncionarioDaoImp();
        Funcionario expResult = null;
        Funcionario result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testGetTodos() {
        System.out.println("getTodos");
        FuncionarioDaoImp instance = new FuncionarioDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSalva() {
        System.out.println("salva");
        Funcionario func = new Funcionario();
        Endereco endereco = new Endereco();
        Usuario usu = new Usuario();
        
        List<Endereco> enderecos = new ArrayList<Endereco>();
        func.setAtivo(true);
        func.setNome("teste3");
        func.setEmail("teste3");
        func.setTelefone("test3");
        func.setNascimento("teste3");
        func.setRg("teste3");
        func.setCpf("teste");
        func.setFuncao("teste");
        
        usu.setLogin("124");
        usu.setSenha("123");
        usu.setLogado(true);
        func.setUsuario(usu);
        
        endereco.setRua("test2");
        endereco.setNumero("tes2");
        endereco.setComplemento("test2");
        endereco.setPontoReferencia("test2");
        endereco.setBairro("test2");
        endereco.setCidade("teste2");
        enderecos.add(endereco);
        func.setEnderecos(enderecos);
        
        FuncionarioDao dao = new FuncionarioDaoImp();
        Funcionario result = dao.salva(func);
        for (Endereco endereco1 : result.getEnderecos()) {
            EnderecoDao edao = new EnderecoDaoImp();
            endereco1.setPessoa(result);
            edao.salva(endereco1);
        }
        assertNotNull(result);
    }
}
