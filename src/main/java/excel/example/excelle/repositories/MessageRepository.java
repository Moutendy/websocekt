package excel.example.excelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import excel.example.excelle.model.Message;
import excel.example.excelle.model.Personne;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	Integer countByDestinationUserAndMessage(Personne user, String message);
}
 