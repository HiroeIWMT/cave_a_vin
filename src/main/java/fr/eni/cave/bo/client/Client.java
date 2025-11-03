package fr.eni.cave.bo.client;
import fr.eni.cave.bo.Utilisateur;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

//ils sont les annotations de librairie Lombok
//permet d'avoir un constructor sans augument
@NoArgsConstructor

//permet d'avoir un constructor tous les augument
@AllArgsConstructor

@Getter
@Setter

//表示するフィールドを選べる→ motDePasse など 見せたくない情報を除外 できる
@ToString(of = { "pseudo", "nom", "prenom" })

//Java では、2つのオブジェクトを「同じ」とみなす基準を定義するのが equals()。
//hashCode() は、同じオブジェクトをハッシュ構造（HashSet, HashMap など）で扱うために必要な対応関数です。
//equals() と hashCode() は、pseudo フィールドだけを使って オブジェクトの等価性を判断する
//つまり、pseudo が同じなら、nom や prenom が違っても 同じオブジェクトとみなす。
@EqualsAndHashCode(of = { "pseudo" })
@SuperBuilder
//persistéé =>データベースに保存される
@Entity

@Table(name = "CAV_CLIENT")
//@Builder
public class Client extends Utilisateur {
        //conficuration spécifique chaque colomn
        /*
        @Id
        @Column(name = "LOGIN", nullable = false, length = 255)
        private String pseudo;
        */

        //TP2
        @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        @JoinColumn(name = "ADDRESS_ID")
        private Adresse adresse;

        // @ToString.Exclude
        /*
        @Column(name = "PASSWPORD", nullable = false, length = 68)
        private String password;
        @Column(name = "LAST_NAME", nullable = false, length = 90)
        private String nom;
        @Column(name = "FIRST_NAME", nullable = false, length = 150)
        private String prenom;
        */
}
