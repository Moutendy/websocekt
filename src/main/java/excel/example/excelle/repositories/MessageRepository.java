package excel.example.excelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.HelloMessage;

@Repository
public interface MessageRepository extends JpaRepository<HelloMessage, Long>{

}
