package entities;

import jakarta.persistence.*;
/**
 * Entity qui correspond à la table additif
 * @author  kone mamoudou et khalid
 *
 */
@Entity
@Table(name = "additif")
public class Additif {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom")
    private String nom;
}
