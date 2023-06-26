package entities;

import jakarta.persistence.*;

/**
 * Class qui correspond à la table Marque
 * @author  kone mamoudou
 *
 */
@Entity
@Table(name = "marque")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
