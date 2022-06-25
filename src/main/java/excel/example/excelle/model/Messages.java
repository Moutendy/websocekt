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
@Table(name="MESSAGES")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Messages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MESSAGE")
	private Long id;
	
	private String message;
	
	private String emetteur;
		@ManyToOne
		@JoinColumn(name = "ID_PERSONNE") 
    private Personne personne;
		
		private boolean statutmessage;
}
