package excel.example.excelle.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.AdresseModel;

@Repository
public interface IAdresseRepository extends JpaRepository<AdresseModel, Long>{

	
	@Query("SELECT a"
			+ "	FROM AdresseModel a WHERE a.pays=:pays")
	public  Collection<AdresseModel> getAdresse(@Param("pays")String pays);
	
}
