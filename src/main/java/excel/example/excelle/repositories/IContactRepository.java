package excel.example.excelle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import excel.example.excelle.model.ContactModel;

@Repository
public interface IContactRepository extends JpaRepository<ContactModel, Long>{
	
	List<ContactModel> findByProprietaire(String proprietaire);

}
