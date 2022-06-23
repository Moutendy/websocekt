package excel.example.excelle.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.Message;
import excel.example.excelle.model.Personne;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	 
	@Query(value ="SELECT u FROM "
			+ "Message u WHERE u.personne_id =:personne_id "
			+ "And u.isReadByPersonne=:isReadByPersonne")
	public  List<Message> findMessageByIsReadByPersonneAndPersonne(@Param("isReadByPersonne")Boolean isReadByPersonne,@Param("personne")Personne personne);
}    
 