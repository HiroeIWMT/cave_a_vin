package fr.eni.cave.dal;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import fr.eni.cave.bo.client.Client;
import fr.eni.cave.bo.client.Panier;
public interface PanierRepository extends JpaRepository<Panier, Integer> {
    // Création d'une requête paramétrée avec JPQL
    @Query("SELECT p FROM Panier p WHERE p.client = :client AND p.numCommande = null")
    List<Panier> findPaniersWithJPQL(@Param("client") Client client);
    // Rechercher la liste des paniers non commandés d'un client
    List<Panier> findByNumCommandeNullAndClient(@Param("client") Client client);

    //native sql "nativeQuery = true"
    @Query(value = "SELECT p.* FROM CAV_SHOPPING_CART p WHERE p.CLIENT_ID = :idClient AND p.ORDER_NUMBER IS NOT NULL", nativeQuery = true)
    List<Panier> findByCommandesWithSQL(@Param("idClient") String idClient);

    List<Panier> findByNumCommandeNotNullAndClient(@Param("client") Client client);
}