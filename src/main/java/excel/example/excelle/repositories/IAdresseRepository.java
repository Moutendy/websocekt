package excel.example.excelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.AdresseModel;

@Repository
public interface IAdresseRepository extends JpaRepository<AdresseModel, Long>{

}
