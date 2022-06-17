package excel.example.excelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import excel.example.excelle.model.Customer;


public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
