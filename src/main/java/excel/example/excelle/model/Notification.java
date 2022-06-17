package excel.example.excelle.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "NOTIFICATIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@CreationTimestamp
	@Column(name = "CREATED_AT")
	private Date createdAt;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false, updatable = false)
	private Personne destinationPersonne;
	
	@Column(name = "IS_READ_BY_USER")
	private boolean isReadByPersonne = false;
}
