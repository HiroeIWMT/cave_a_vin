package fr.eni.cave.bo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

//CLASS mére

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"pseudo"})//egalité doit être sur "pseudo!!!", comparaison sur pseudo poue identifier l'utilisateur
@ToString(of={"pseudo","nom","prenom"})//il vaut miux ne pas afficher PASSWORD
@SuperBuilder//Heritage

@Entity
@Table(name="CAV_USER")

@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @Column(name="LOGIN", nullable = false, length = 25)
    private String pseudo;

    @Column(name="PASSWORD", nullable = false, length = 68)
    private String password;

    @Column(name="LAST_NAME", nullable = false, length = 90)
    private String nom;

    @Column(name="FIRST_NAME", nullable = false, length = 150)
    private String prenom;

}
