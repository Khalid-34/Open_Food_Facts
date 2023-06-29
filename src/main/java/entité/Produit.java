package entité;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM")
    private String nom;
    @Column(name = "grade")
    private String grade;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "conditionnement")
    private String conditionnement;

    @Column(name = "nutritionGradeFr")
    private String nutritionGradeFr;

    @Column(name = "graisse100g")
    private double graisse100g;

    @Column(name = "sucres100g")
    private double sucres100g;

    @Column(name = "fibres100g")
    private double fibres100g;

    @Column(name = "proteines100g")
    private double proteines100g;

    @Column(name = "sel100g")
    private double sel100g;

    @ManyToOne
    @JoinColumn(name ="ID_MAR" )
    private  Marque marque;
    @ManyToOne
    @JoinColumn(name ="ID_CAT" )
    private Category category;

    // Jointure de la table produit et ingredient
    @ManyToMany
    @JoinTable(name = "product_ingredient",
            joinColumns = @JoinColumn(name = "product_id",referencedColumnName= "ID"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id",referencedColumnName= "ID"))
    private Set<Ingredient> ingredient;


    public Produit() {
    }

    public Produit(String nom, String grade, int quantite,
                   String conditionnement, String nutritionGradeFr,
                   double graisse100g, double sucres100g, double fibres100g,
                   double proteines100g, double sel100g) {
        this.nom = nom;
        this.grade = grade;
        this.quantite = quantite;
        this.conditionnement = conditionnement;
        this.nutritionGradeFr = nutritionGradeFr;
        this.graisse100g = graisse100g;
        this.sucres100g = sucres100g;
        this.fibres100g = fibres100g;
        this.proteines100g = proteines100g;
        this.sel100g = sel100g;
    }

    public Produit(int id, String nom, String grade, int quantite,
                   String conditionnement, String nutritionGradeFr,
                   double graisse100g, double sucres100g,
                   double fibres100g, double proteines100g, double sel100g) {
        this.id = id;
        this.nom = nom;
        this.grade = grade;
        this.quantite = quantite;
        this.conditionnement = conditionnement;
        this.nutritionGradeFr = nutritionGradeFr;
        this.graisse100g = graisse100g;
        this.sucres100g = sucres100g;
        this.fibres100g = fibres100g;
        this.proteines100g = proteines100g;
        this.sel100g = sel100g;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(String conditionnement) {
        this.conditionnement = conditionnement;
    }

    public String getNutritionGradeFr() {
        return nutritionGradeFr;
    }

    public void setNutritionGradeFr(String nutritionGradeFr) {
        this.nutritionGradeFr = nutritionGradeFr;
    }

    public double getGraisse100g() {
        return graisse100g;
    }

    public void setGraisse100g(double graisse100g) {
        this.graisse100g = graisse100g;
    }

    public double getSucres100g() {
        return sucres100g;
    }

    public void setSucres100g(double sucres100g) {
        this.sucres100g = sucres100g;
    }

    public double getFibres100g() {
        return fibres100g;
    }

    public void setFibres100g(double fibres100g) {
        this.fibres100g = fibres100g;
    }

    public double getProteines100g() {
        return proteines100g;
    }

    public void setProteines100g(double proteines100g) {
        this.proteines100g = proteines100g;
    }

    public double getSel100g() {
        return sel100g;
    }

    public void setSel100g(double sel100g) {
        this.sel100g = sel100g;
    }
}
