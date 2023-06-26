package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Entité qui correspond à la table Ingredient
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "ingrdient")
public class Ingredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private  String nom ;

    /**
     * Plusieurs ingredients peuvent etre dans plusieurs produits
     */
    @ManyToMany
    @JoinTable(name = "produit_ingredient",
            joinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"))
    private Set<Produit> produits = new HashSet<Produit>();



}
