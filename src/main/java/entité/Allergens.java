package entité;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "allergens")
public class Allergens {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOM")
    private String nom;

    @ManyToMany
    @JoinTable(name = "allergens_ingredient",
    joinColumns = @JoinColumn(name = "id_aller",referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "ID"))
    private Set<Ingredient>ingredient;



    public Allergens() {
    }

    public Allergens(String nom) {
        this.nom = nom;
    }

    public Allergens(int id, String nom) {
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

    @Override
    public String toString() {
        return "Allergene{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
