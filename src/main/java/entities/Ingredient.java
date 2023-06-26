package entities;

import jakarta.persistence.*;
/**
 * Entité qui correspond à la table Ingredient
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "ingrdient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
