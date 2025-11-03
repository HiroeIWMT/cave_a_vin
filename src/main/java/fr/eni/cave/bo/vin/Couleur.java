package fr.eni.cave.bo.vin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//POJO
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

//Il est Entité
@Entity
@Table(name="CAV_COLOR")
public class Couleur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COLOR_ID")
    private Integer id;

    @Column(name="NAME", length = 250, unique = true, nullable = false)
    private String nom;
}
