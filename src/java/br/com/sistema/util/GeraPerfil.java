/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.util;

import br.com.sistema.dao.PerfilDao;
import br.com.sistema.dao.PerfilDaoImp;
import br.com.sistema.entidade.ClienteOnline;
import br.com.sistema.entidade.Funcionario;
import br.com.sistema.entidade.Perfil;
import br.com.sistema.entidade.PessoaFisica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class GeraPerfil {

    public static List<Perfil> perfis(PessoaFisica pf) {
        List<Perfil> perfils = new ArrayList<Perfil>();
        if (pf instanceof ClienteOnline) {
            String[] perfis = {""};
            PerfilDao dao = new PerfilDaoImp();
            for (String string : perfis) {
                Perfil perfil = dao.buscarPerfil(string);
                perfils.add(perfil);
            }

        } else {
            Funcionario func = (Funcionario) pf;
            if (func.getFuncao().equals("")) {
                String[] perfis = {""};
                PerfilDao dao = new PerfilDaoImp();
                for (String string : perfis) {
                    Perfil perfil = dao.buscarPerfil(string);
                    perfils.add(perfil);
                }
            } else {
                String[] perfis = {""};
                PerfilDao dao = new PerfilDaoImp();
                for (String string : perfis) {
                    Perfil perfil = dao.buscarPerfil(string);
                    perfils.add(perfil);
                }
            }
        }
        return perfils;
    }
}
