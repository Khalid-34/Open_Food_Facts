package entité;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOM")
    private String nom;
    @ManyToMany
    @JoinTable(name = "ingredient_additif",
    joinColumns = @JoinColumn(name = "id_ing",referencedColumnName= "ID"),
    inverseJoinColumns = @JoinColumn(name = "id_addif" ,referencedColumnName= "ID"))
    private Set<Additifs> additifs;

    @ManyToMany(mappedBy = "ingredient")
    private Set<Produit>produit;

    @ManyToMany(mappedBy = "ingredient")
    private Set<Allergens> allergens;

    public Ingredient() {
    }

    public Ingredient(String nom) {
        this.nom = nom;
    }

    public Ingredient(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
