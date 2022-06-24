package excel.example.excelle.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.Personne;
@Repository
public interface IPersonneRepository extends JpaRepository<Personne, Long>{

	@Query(value="SELECT u FROM Personne u WHERE u.name = :name And u.adressemodel.ville = :ville And u.compte.solde= :solde")
			Collection<Personne> findAllActiveUsersNative(@Param("name")String name,@Param("ville")String ville,@Param("solde")double solde);
	
}
