package entité;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "additifs")
public class Additifs {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOM")
    private String nom;

    @Column(name = "code")
    private String code;

    @ManyToMany(mappedBy = "additifs")
    private Set<Ingredient>ingredient;

    public Additifs() {
    }

    public Additifs(String nom, String code) {
        this.nom = nom;
        this.code = code;
    }

    public Additifs(int id, String nom, String code) {
        this.id = id;
        this.nom = nom;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
