package excel.example.excelle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PERSONNE")
public class Personne {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONNE")
	private Long id;
	 private String name;
	 
	 private Boolean genre;
	 
	 private int taille;
	  
	@ManyToOne
	@JoinColumn(name = "ID_ADRESSE") 
	 private AdresseModel adressemodel;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;
  
}
