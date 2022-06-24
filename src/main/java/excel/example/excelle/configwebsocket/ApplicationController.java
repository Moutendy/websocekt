package excel.example.excelle.configwebsocket;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.excelle.model.AdresseModel;
import excel.example.excelle.model.Compte;
import excel.example.excelle.model.ContactModel;
import excel.example.excelle.model.Messages;
import excel.example.excelle.model.Personne;
import excel.example.excelle.repositories.IAdresseRepository;
import excel.example.excelle.repositories.ICompteRepository;
import excel.example.excelle.repositories.IContactRepository;
import excel.example.excelle.repositories.IMessageRepository;
import excel.example.excelle.repositories.IPersonneRepository;

@RestController
public class ApplicationController {

	
	@Autowired
	IPersonneRepository ipersonne;
	
	@Autowired
	IAdresseRepository iadresse;
	
	@Autowired
	ICompteRepository icompte;
	
	@Autowired
	IMessageRepository imessagerepository;
	
	@Autowired
	IContactRepository icontact;
	
	@GetMapping(value="/afficherpersonne/{name}/{ville}/{solde}")
	public Collection<Personne> afficherPersonne(@PathVariable String name,@PathVariable String ville,@PathVariable double solde)throws Exception  
	{
		
System.out.println(name);

System.out.println(ville);

	return	ipersonne.findAllActiveUsersNative(name,ville,solde);
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
	
	@PostMapping(value="/ajoutermessage")
	public void ajouterMEssage(@RequestBody Messages message)throws Exception  
	{
		message.setStatutmessage(false);
		imessagerepository.save(message); 
	}
	
	
	
	@PostMapping(value="/ajoutercontact")
	public void ajouterContact(@RequestBody ContactModel contact)throws Exception  
	{
	
		icontact.save(contact);
	}
	
	
	
	
	@GetMapping(value="/mescontact/{proprietaire}")
	public List<ContactModel> mescontact(@PathVariable String proprietaire)throws Exception  
	{
		return icontact.findByProprietaire(proprietaire);
	}
	
	
	@GetMapping(value="/affichermessagerie/{emetteur}")
	public Collection<Messages> afficherMessage(@PathVariable String emetteur)throws Exception  
	{
		return imessagerepository.getMessage(emetteur);
	}
	
	@GetMapping(value="/afficheradresse/{emetteur}")
	public Collection<AdresseModel> afficherAdresse(@PathVariable String pays)throws Exception  
	{
		return iadresse.getAdresse(pays);
	}
	
	@GetMapping(value="/messagenolu")
	public Collection<Messages> messageNoLu()throws Exception  
	{
		return imessagerepository.findByStatutmessage(false);
	}
	
	
	@GetMapping(value="/affichercompte/{id}")
	public Collection<Compte> ajouterCompte(@PathVariable Long id)throws Exception  
	{
		 return  icompte.findAll().stream()
        .filter(icom -> icom.id==id)
        .collect(Collectors.toList());
	  
	}
	
	@GetMapping(value="/messages/{statut}")
	public Collection<Messages> messages(@PathVariable boolean statut)throws Exception  
	{
		return imessagerepository.findAll().stream().filter(mes->mes.isStatutmessage()==statut).collect(Collectors.toList());
	}
	
	@GetMapping(value="/messagesdebut/{prefix}")
	List<Messages> messages(@PathVariable String prefix)
	{
		return imessagerepository.findByMessageStartingWith(prefix);
	}
}
