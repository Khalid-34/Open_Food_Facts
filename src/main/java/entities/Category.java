package entities;

import jakarta.persistence.*;

/**
 * Class qui correspond à la table categorie
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
