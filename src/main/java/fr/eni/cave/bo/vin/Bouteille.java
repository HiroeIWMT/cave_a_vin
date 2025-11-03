package fr.eni.cave.bo.vin;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

//POJO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder

//Il est Entité
@Entity
@Table(name="CAV_BOTTLE")
public class Bouteille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOTTLE_ID")
    private Integer id;

    @Column(name="NAME", length = 250, unique = true, nullable = false)
    private String nom;

    @Column(name="SPARKLING", length = 250, unique = true, nullable = false)
    private boolean petillant;

    @Column(name="VINTAGE", length = 100)
    private String millesime;

    @Column(name="QUANTITY")
    private int quantite;

    @Column(name="PRICE", precision = 10, scale=2)
    //private int prix;
    private BigDecimal prix;

    //une bouteille correspond une région
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name="REGION_ID")
    private Region region;

    //une bouteille correspond une coleur
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name="COLOR_ID")
    private Couleur couleur;

}
