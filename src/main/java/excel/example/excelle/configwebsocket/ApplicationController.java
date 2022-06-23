package excel.example.excelle.configwebsocket;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.excelle.model.AdresseModel;
import excel.example.excelle.model.Compte;
import excel.example.excelle.model.Personne;
import excel.example.excelle.repositories.IAdresseRepository;
import excel.example.excelle.repositories.ICompteRepository;
import excel.example.excelle.repositories.IPersonneRepository;

@RestController
public class ApplicationController {

	
	@Autowired
	IPersonneRepository ipersonne;
	
	@Autowired
	IAdresseRepository iadresse;
	
	@Autowired
	ICompteRepository icompte;
	
	@GetMapping(value="/afficherpersonne")
	public Collection<Personne> afficherPersonne()throws Exception  
	{
		

	return	ipersonne.findAllActiveUsersNative();
	}
	
	@PostMapping(value="/ajouterpersonne")
	public void ajouterPersonne(@RequestBody Personne personne)throws Exception  
	{
		ipersonne.save(personne);
	}
	
	@PostMapping(value="/ajoutercompte")
	public void ajouterCompte(@RequestBody Compte compte)throws Exception  
	{
		icompte.save(compte);
	}
	
	@PostMapping(value="/ajouteradresse")
	public void ajouterAdresse(@RequestBody AdresseModel adresse)throws Exception  
	{
		iadresse.save(adresse);
	}
	
}
