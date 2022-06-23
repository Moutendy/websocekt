package excel.example.excelle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="ADRESSE")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdresseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADRESSE")
	private Long id;
	
	@Column(name = "ADRESSE")
	private String adresse;
	
	@Column(name = "VILLE")
	private String ville;
	
	
	@Column(name = "PAYS")
	private String pays;
}
