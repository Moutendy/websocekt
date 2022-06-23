package excel.example.excelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.Compte;

@Repository
public interface ICompteRepository extends JpaRepository<Compte, Long>{

}
