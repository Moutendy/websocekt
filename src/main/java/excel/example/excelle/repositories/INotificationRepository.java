package excel.example.excelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.Notification;
import excel.example.excelle.model.Personne;


@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long>{

//	Integer countByDestinationPersonneAndIsReadByPersonne(Personne user, Boolean isRead);
//	
	static final String UPDATE_NOTIF_BY_USER_ID = "UPDATE "
			+ "NOTIFICATIONS n "
			+ "SET is_read_by_user = true "
			+ "WHERE user_id = :userId";
	
	@Modifying
	@Query(value = UPDATE_NOTIF_BY_USER_ID, nativeQuery = true)
	void updateNotifByUserId(@Param("userId") Long userId);
	
	
} 
