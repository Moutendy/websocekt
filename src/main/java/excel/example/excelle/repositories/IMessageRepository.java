package excel.example.excelle.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.Messages;



@Repository
public interface IMessageRepository extends JpaRepository<Messages, Long>{
	
	   @Query(value="SELECT m FROM Messages m WHERE m.emetteur=:emetteur")
	  public Collection<Messages> getMessage(@Param("emetteur") String emetteur);
	   
	   
	   public List<Messages> findByStatutmessage(boolean statutmessage);
	   
	   
	   
	   
	   List<Messages> findByMessageStartingWith(String prefix);
	   
	 
		
		@Modifying
		@Query(value = "update"
				+ " MESSAGES m "
				+ "set statutmessage = true "
				+ "WHERE id_personne = :personneId", nativeQuery = true)
		void updateNotifByUserId(@Param("personneId") Long personneId);
	   
}


