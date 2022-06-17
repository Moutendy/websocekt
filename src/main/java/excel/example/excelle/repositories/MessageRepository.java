package excel.example.excelle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.HelloMessage;
import excel.example.excelle.model.Personne;

@Repository
public interface MessageRepository extends JpaRepository<HelloMessage, Long>{

	Integer countByDestinationUserAndIsReadByUser(Personne personne,Boolean isRead);
	

	
	
@Query("SELECT u FROM HelloMessage u WHERE u.statut = :statut")
List<HelloMessage> message(@Param("statut") String statut);
}
