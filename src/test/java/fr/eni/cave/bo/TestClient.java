package fr.eni.cave.bo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import fr.eni.cave.bo.client.Client;
import fr.eni.cave.dal.ClientRepository;
import lombok.extern.slf4j.Slf4j;

//Pour le log
@Slf4j
//JPA 層だけをテストするためのスライステスト用アノテーション。不要な Bean（Controller / Service 等）は読み込まないため、テストが速く・単純になる。
@DataJpaTest
public class TestClient {

    //injections de dépendances
    //Spring が自動でオブジェクト（Bean）を注入してくれる仕組み。
    // @AuSpring が自動で TestEntityManager と ClientRepository のインスタンスを作って、
   // テストクラスに「注入」してくれます。towired
    private TestEntityManager entityManager;
    @Autowired
    ClientRepository repository;

    //Test1 Clientをビルダーで作成しDBにINSERT
    @Test
    public void test_save() {
        final Client client = Client
                .builder()
                .pseudo("bobeponge@email.fr")
                .password("carré")
                .nom("Eponge")
                .prenom("Bob")
                .build();
// Appel du comportement
        final Client clientDB = repository.save(client);
        log.info(clientDB.toString());
// Vérification de la cascade de l'association
        assertThat(clientDB).isNotNull();
        assertThat(clientDB).isEqualTo(client);//comparaison entre le donnée de DB et Client qui a été carée en Builder
    }

    //Test2
    @Test
    public void test_delete() {
        final Client client = Client
                .builder()
                .pseudo("bobeponge@email.fr")
                .password("carré")
                .nom("Eponge")
                .prenom("Bob")
                .build();
// Contexte de la DB
        entityManager.persist(client);
        entityManager.flush();
        log.info(client.toString());
// Appel du comportement
        repository.delete(client);
// Vérification que l'entité a été supprimée

//il va aller chercher dans la Base de données en utilisant entityManager, le client qui correspont ce Pseudo
        Client clientDB = entityManager.find(Client.class, client.getPseudo());
        assertNull(clientDB);
    }
}