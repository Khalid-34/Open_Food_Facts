package entité;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "additifs")
public class Additifs {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOM")
    private String nom;

    @Column(name = "code")
    private String code;

    @ManyToMany(mappedBy = "additifs")
    private Set<Ingredient>ingredient;

}
