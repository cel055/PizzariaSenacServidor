/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.entidade.Endereco;
import br.com.sistema.entidade.Fornecedor;
import br.com.sistema.entidade.PessoaJuridica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class PessoaFisicaDaoImpTest {
    
    @Test
    public Fornecedor testSalva() {
        System.out.println("salva");
        Fornecedor fornecedor = new Fornecedor();
        Endereco endereco = new Endereco();
        Endereco end = new Endereco();
        List<Endereco> enderecos = new ArrayList<Endereco>();
        fornecedor.setAtivo(true);
        fornecedor.setNome("teste");
        fornecedor.setEmail("teste");
        fornecedor.setTelefone("teste");
        fornecedor.setCnpj("teste");
        fornecedor.setNomeFantasia("teste");
        fornecedor.setFax("teste");
        fornecedor.setRazaoSocial("teste");
        fornecedor.setSegundoTel("teste");
        fornecedor.setDataCriacao(new Date());
        end.setRua("teste");
        end.setNumero("teste");
        end.setComplemento("teste");
        end.setPontoReferencia("teste");
        end.setBairro("teste");
        end.setCidade("teste");
        endereco.setRua("teste2");
        endereco.setNumero("test2");
        endereco.setComplemento("teste2");
        endereco.setPontoReferencia("teste2");
        endereco.setBairro("teste2");
        endereco.setCidade("teste2");
        enderecos.add(endereco);
        enderecos.add(end);
        fornecedor.setEnderecos(enderecos);
        FornecedorDao dao = new FornecedorDaoImp();
        Fornecedor result = dao.salva(fornecedor);
        for (Endereco endereco1 : result.getEnderecos()) {
            EnderecoDao edao = new EnderecoDaoImp();
            endereco1.setPessoa(result);
            edao.salva(endereco1);
        }
        assertNotNull(result);
        return result;
    }

//    @Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        PessoaJuridicaDaoImp instance = new PessoaJuridicaDaoImp();
        PessoaJuridica expResult = null;
        PessoaJuridica result = instance.pesquisaPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testGetTodos() {
        System.out.println("getTodos");
        PessoaJuridicaDaoImp instance = new PessoaJuridicaDaoImp();
        List expResult = null;
        List result = instance.getTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
