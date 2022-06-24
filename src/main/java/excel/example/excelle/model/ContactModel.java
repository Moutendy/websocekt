package excel.example.excelle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="CONTACT")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContactModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTACT")
	private Long id;
	
	private String proprietaire;

		@ManyToOne
		@JoinColumn(name = "ID_PERSONNE") 
    private Personne personne;
		
}
