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


	
	
	
} 
