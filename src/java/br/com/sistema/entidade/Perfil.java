/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Mateus
 */
@Entity
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(name="perfil_usuario", joinColumns=@JoinColumn(name="id_perfil"), inverseJoinColumns=@JoinColumn(name="id_usuario"))
    private List<Usuario> usuarios;
    @Column
    private String nomeMenu;
//    @Column
//    private String nomeSubMenu;
    @Column
    private String valueMenu;
//    @Column
//    private String valueSubMenu;
//    @Column
//    private String javascript;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMenu() {
        return nomeMenu;
    }

    public void setNomeMenu(String nomeMenu) {
        this.nomeMenu = nomeMenu;
    }

//    public String getNomeSubMenu() {
//        return nomeSubMenu;
//    }
//
//    public void setNomeSubMenu(String nomeSubMenu) {
//        this.nomeSubMenu = nomeSubMenu;
//    }

    public String getValueMenu() {
        return valueMenu;
    }

    public void setValueMenu(String valueMenu) {
        this.valueMenu = valueMenu;
    }

//    public String getValueSubMenu() {
//        return valueSubMenu;
//    }
//
//    public void setValueSubMenu(String valueSubMenu) {
//        this.valueSubMenu = valueSubMenu;
//    }
//
//    public String getJavascript() {
//        return javascript;
//    }
//
//    public void setJavascript(String javascript) {
//        this.javascript = javascript;
//    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistema.entidade.Perfil[ id=" + id + " ]";
    }
    
}
