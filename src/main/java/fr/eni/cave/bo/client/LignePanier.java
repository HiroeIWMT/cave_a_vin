package fr.eni.cave.bo.client;
import fr.eni.cave.bo.vin.Bouteille;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//equals sur l'attribut id
@EqualsAndHashCode(of = { "id" })
@ToString
@Builder
@Entity
@Table(name = "CAV_LINE")
public class LignePanier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LINE_ID")
    private Integer id;

    @Column(name="QUANTITY")
    private int quantite;


    @Column(name="PRICE", precision = 10, scale = 2)
    private BigDecimal prix;
    //@Column(name="PRICE", precision = 2)
    //private float prix;

    @ManyToOne
    @JoinColumn(name = "BOTTLE_ID")
    private Bouteille bouteille;
}