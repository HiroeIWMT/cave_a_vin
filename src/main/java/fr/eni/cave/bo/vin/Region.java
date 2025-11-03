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
@Table(name="CAV_REGION")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REGION_ID")
    private Integer id;

    @Column(name="NAME", length = 250, unique = true, nullable = false)
    private String nom;
}
