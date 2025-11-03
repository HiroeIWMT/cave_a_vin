package fr.eni.cave.dal;

import fr.eni.cave.bo.vin.Couleur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurRepository extends JpaRepository<Couleur, Integer> {


}
