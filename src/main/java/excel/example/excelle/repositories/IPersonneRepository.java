package excel.example.excelle.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.Personne;
@Repository
public interface IPersonneRepository extends JpaRepository<Personne, Long>{

	@Query(
			  value = "SELECT p.*"+" FROM Personne p,AdresseModel a"+" WHERE p.taille = 165"+" WHERE a.adresse = Avenue HASSAN II", 
			  nativeQuery = true)
			Collection<Personne> findAllActiveUsersNative();
	
}
