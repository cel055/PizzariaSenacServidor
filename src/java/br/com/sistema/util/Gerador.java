/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.util;

import br.com.sistema.dao.PerfilDao;
import br.com.sistema.dao.PerfilDaoImp;
import br.com.sistema.entidade.Perfil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class Gerador {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Sistema1.0PU");
        EntityManager manager = factory.createEntityManager();
//        Perfil perfil;
//        PerfilDao dao = new PerfilDaoImp();
//        perfil = new Perfil();
//        perfil.setNomeMenu("");
//        perfil.setValueMenu("");
//        dao.salva(perfil);
//        perfil = new Perfil();
//        perfil.setNomeMenu("");
//        perfil.setValueMenu("");
//        dao.salva(perfil);
    }
}
