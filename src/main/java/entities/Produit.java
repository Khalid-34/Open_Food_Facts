package entities;

import jakarta.persistence.*;
import jdk.jfr.Category;

import java.util.LinkedHashSet;
import java.util.Set;
/**
 * Entité qui correspond à la table produit
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "product")
public class Produit {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 50)
    private  String nom;

    @ManyToOne
    @JoinColumn( name = "id_categorie")
    private Category category_product;

    // Jointure de la table produit et ingredient
    @ManyToMany
    @JoinTable(name = "product_ingredient",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    // Jointure de la table produit et additif

    @ManyToMany
    @JoinTable(name = "product_additif",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "additif_id"))
    private Set<Additif> additifs = new LinkedHashSet<>();

    // Jointure de la table produit et marque

    @ManyToMany
    @JoinTable(name = "product_marque",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "marque_id"))
    private Set<Marque> marques = new LinkedHashSet<>();
}
