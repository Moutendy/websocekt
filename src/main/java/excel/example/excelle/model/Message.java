package excel.example.excelle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id; 
	
	private String emetteur;
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "PERSONNE_ID", nullable = false, updatable = false)
	private Personne personne_id;
	
	
	@Column(name = "IS_READ_BY_USER")
	private boolean isReadByPersonne = false;
}
