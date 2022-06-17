package excel.example.excelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import excel.example.excelle.model.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long>{

}
