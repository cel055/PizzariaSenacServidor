/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author CamposCosta
 */
@Entity
public class PratoQuente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false, length=20)
    private String nome;
    
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="ingredPratoQuente", joinColumns=@JoinColumn(name="id_pratoQuente"), inverseJoinColumns=@JoinColumn(name="id_ingredientePizza"))
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<IngredientePizza> ingredientes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<IngredientePizza> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredientePizza> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        if (!(object instanceof PratoQuente)) {
            return false;
        }
        PratoQuente other = (PratoQuente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistema.entidade.PratoQuente[ id=" + id + " ]";
    }
    
}
