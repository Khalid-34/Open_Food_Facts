package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entité qui correspond à la table produit
 * @author kone mamoudou
 */
@Entity
@Table(name = "produit")
@Cacheable
public class Produit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "grade")
    private String grade;
    @Column(name = "energie100g")
    private Double energie100g;
    @Column(name = "graisse100g")

    private Double graisse100g;
    @Column(name = "sucres100g")

    private Double sucres100g;
    @Column(name = "fibres100g")

    private Double fibres100g;
    @Column(name = "proteines100g")

    private Double proteines100g;
    @Column(name = "sel100g")

    private Double sel100g;
    @Column(name = "vitA100g")

    private Double vitA100g;
    @Column(name = "vitD100g")
    private Double vitD100g;
    @Column(name = "vitE100g")
    private Double vitE100g;
    @Column(name = "vitK100g")
    private Double vitK100g;
    @Column(name = "vitC100g")
    private Double vitC100g;
    @Column(name = "vitB1100g")
    private Double vitB1100g;
    @Column(name = "vitB2100g")

    private Double vitB2100g;
    @Column(name = "vitPP100g")

    private Double vitPP100g;
    @Column(name = "vitB6100g")
    private Double vitB6100g;
    @Column(name = "vitB9100g")
    private Double vitB9100g;
    @Column(name = "vitB12100g")
    private Double vitB12100g;
    @Column(name = "calcium100g")
    private Double calcium100g;
    @Column(name = "magnesium100g")

    private Double magnesium100g;
    @Column(name = "iron100g")

    private Double iron100g;
    @Column(name = "fer100g")

    private Double fer100g;
    @Column(name = "betaCarotene100g")

    private Double betaCarotene100g;

    /**
     * Plusieurs produits peuvent avoir une categorie
     */
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private Category category;

    /**
     * Plusieurs produits peuvent avoir une marque
     */
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_marque")
    private Marque marque;

    /**
     * Plusieurs produits peuvent avoir plusieurs ingredients
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "produit_ingredient",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id"))
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    /**
     * Plusieurs produits peuvent avoir plusieurs additifs
     * */
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "produit_additif",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_additif", referencedColumnName = "id"))
    private Set<Additif> additifs = new HashSet<Additif>();

    /**
     * Plusieurs produits peuvent avoir plusieurs allergies
     * */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "produit_allergie",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_allergie", referencedColumnName = "id"))
    private Set<Allergie> allergie = new HashSet<Allergie>();

    /** * Constructeur */
    public Produit() {}

    public Produit(String nom) {
        this.nom = nom;
    }

    public Produit(String nom, String grade, Double energie100g, Double graisse100g, Double sucres100g, Double fibres100g, Double proteines100g, Double sel100g, Double vitA100g, Double vitD100g, Double vitE100g, Double vitK100g, Double vitC100g, Double vitB1100g, Double vitB2100g, Double vitPP100g, Double vitB6100g, Double vitB9100g, Double vitB12100g, Double calcium100g, Double magnesium100g, Double iron100g, Double fer100g, Double betaCarotene100g, Category category, Marque marque, Set<Ingredient> ingredients, Set<Additif> additifs, Set<Allergie> allergie) {
        this.nom = nom;
        this.grade = grade;
        this.energie100g = energie100g;
        this.graisse100g = graisse100g;
        this.sucres100g = sucres100g;
        this.fibres100g = fibres100g;
        this.proteines100g = proteines100g;
        this.sel100g = sel100g;
        this.vitA100g = vitA100g;
        this.vitD100g = vitD100g;
        this.vitE100g = vitE100g;
        this.vitK100g = vitK100g;
        this.vitC100g = vitC100g;
        this.vitB1100g = vitB1100g;
        this.vitB2100g = vitB2100g;
        this.vitPP100g = vitPP100g;
        this.vitB6100g = vitB6100g;
        this.vitB9100g = vitB9100g;
        this.vitB12100g = vitB12100g;
        this.calcium100g = calcium100g;
        this.magnesium100g = magnesium100g;
        this.iron100g = iron100g;
        this.fer100g = fer100g;
        this.betaCarotene100g = betaCarotene100g;
        this.category = category;
        this.marque = marque;
        this.ingredients = ingredients;
        this.additifs = additifs;
        this.allergie = allergie;
    }

    /** Getters et Setters **/
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Double getEnergie100g() {
        return energie100g;
    }

    public void setEnergie100g(Double energie100g) {
        this.energie100g = energie100g;
    }

    public Double getGraisse100g() {
        return graisse100g;
    }

    public void setGraisse100g(Double graisse100g) {
        this.graisse100g = graisse100g;
    }

    public Double getSucres100g() {
        return sucres100g;
    }

    public void setSucres100g(Double sucres100g) {
        this.sucres100g = sucres100g;
    }

    public Double getFibres100g() {
        return fibres100g;
    }

    public void setFibres100g(Double fibres100g) {
        this.fibres100g = fibres100g;
    }

    public Double getProteines100g() {
        return proteines100g;
    }

    public void setProteines100g(Double proteines100g) {
        this.proteines100g = proteines100g;
    }

    public Double getSel100g() {
        return sel100g;
    }

    public void setSel100g(Double sel100g) {
        this.sel100g = sel100g;
    }

    public Double getVitA100g() {
        return vitA100g;
    }

    public void setVitA100g(Double vitA100g) {
        this.vitA100g = vitA100g;
    }

    public Double getVitD100g() {
        return vitD100g;
    }

    public void setVitD100g(Double vitD100g) {
        this.vitD100g = vitD100g;
    }

    public Double getVitE100g() {
        return vitE100g;
    }

    public void setVitE100g(Double vitE100g) {
        this.vitE100g = vitE100g;
    }

    public Double getVitK100g() {
        return vitK100g;
    }

    public void setVitK100g(Double vitK100g) {
        this.vitK100g = vitK100g;
    }

    public Double getVitC100g() {
        return vitC100g;
    }

    public void setVitC100g(Double vitC100g) {
        this.vitC100g = vitC100g;
    }

    public Double getVitB1100g() {
        return vitB1100g;
    }

    public void setVitB1100g(Double vitB1100g) {
        this.vitB1100g = vitB1100g;
    }

    public Double getVitB2100g() {
        return vitB2100g;
    }

    public void setVitB2100g(Double vitB2100g) {
        this.vitB2100g = vitB2100g;
    }

    public Double getVitPP100g() {
        return vitPP100g;
    }

    public void setVitPP100g(Double vitPP100g) {
        this.vitPP100g = vitPP100g;
    }

    public Double getVitB6100g() {
        return vitB6100g;
    }

    public void setVitB6100g(Double vitB6100g) {
        this.vitB6100g = vitB6100g;
    }

    public Double getVitB9100g() {
        return vitB9100g;
    }

    public void setVitB9100g(Double vitB9100g) {
        this.vitB9100g = vitB9100g;
    }

    public Double getVitB12100g() {
        return vitB12100g;
    }

    public void setVitB12100g(Double vitB12100g) {
        this.vitB12100g = vitB12100g;
    }

    public Double getCalcium100g() {
        return calcium100g;
    }

    public void setCalcium100g(Double calcium100g) {
        this.calcium100g = calcium100g;
    }

    public Double getMagnesium100g() {
        return magnesium100g;
    }

    public void setMagnesium100g(Double magnesium100g) {
        this.magnesium100g = magnesium100g;
    }

    public Double getIron100g() {
        return iron100g;
    }

    public void setIron100g(Double iron100g) {
        this.iron100g = iron100g;
    }

    public Double getFer100g() {
        return fer100g;
    }

    public void setFer100g(Double fer100g) {
        this.fer100g = fer100g;
    }

    public Double getBetaCarotene100g() {
        return betaCarotene100g;
    }

    public void setBetaCarotene100g(Double betaCarotene100g) {
        this.betaCarotene100g = betaCarotene100g;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Additif> getAdditif() {
        return additifs;
    }

    public void setAdditif(Set<Additif> additif) {
        this.additifs = additif;
    }

    public Set<Allergie> getAllergie() {
        return allergie;
    }

    public void setAllergie(Set<Allergie> allergie) {
        this.allergie = allergie;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", grade='" + grade + '\'' +
                ", energie100g=" + energie100g +
                ", graisse100g=" + graisse100g +
                ", sucres100g=" + sucres100g +
                ", fibres100g=" + fibres100g +
                ", proteines100g=" + proteines100g +
                ", sel100g=" + sel100g +
                ", vitA100g=" + vitA100g +
                ", vitD100g=" + vitD100g +
                ", vitE100g=" + vitE100g +
                ", vitK100g=" + vitK100g +
                ", vitC100g=" + vitC100g +
                ", vitB1100g=" + vitB1100g +
                ", vitB2100g=" + vitB2100g +
                ", vitPP100g=" + vitPP100g +
                ", vitB6100g=" + vitB6100g +
                ", vitB9100g=" + vitB9100g +
                ", vitB12100g=" + vitB12100g +
                ", calcium100g=" + calcium100g +
                ", magnesium100g=" + magnesium100g +
                ", iron100g=" + iron100g +
                ", fer100g=" + fer100g +
                ", betaCarotene100g=" + betaCarotene100g +
                ", category=" + category +
                ", marque=" + marque +
                ", ingredients=" + ingredients +
                ", additifs=" + additifs +
                ", allergie=" + allergie +
                '}';
    }


}
