package excel.example.excelle.configwebsocket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.excelle.model.Customer;
import excel.example.excelle.model.HelloMessage;
import excel.example.excelle.model.Notification;
import excel.example.excelle.model.Personne;
import excel.example.excelle.repositories.CustomerRepository;
import excel.example.excelle.repositories.INotificationRepository;
import excel.example.excelle.repositories.IPersonneRepository;
import excel.example.excelle.repositories.MessageRepository;

@RestController
public class GreetingController {

	@Autowired
	MessageRepository messagerepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	IPersonneRepository ipersonne;
	@Autowired
	INotificationRepository notif;
	
	@Autowired
	NotificationService notificationService;
	
	@MessageMapping(value="/hello")
	@SendTo("/topic/notifUser")
	@GetMapping(value="/receptionmessage")
	public List<HelloMessage> greet()
	{
		 String statut="nonlu";
		return messagerepository.message(statut);
	}
	
	@Transactional
	@GetMapping(value="/lire")
	public void greetlire(Long id)
	{
		 id=(long) 1;
		 notif.updateNotifByUserId(id);
	}
	

	@PostMapping(value="/envoimessage")
	public void send()throws Exception  
	{
		Notification notification = new Notification();
		Personne persone= new Personne();
		
		Long id=(long) 1;
		persone.setId(id);
		notification.setDestinationPersonne(persone);
		notif.save(notification);
	

	}
	
	
	@PostMapping(value="/customer")
	public void sendTeste(@RequestBody Customer custome)throws Exception  
	{

		customerRepository.save(custome);

	}
	
	@GetMapping(value="/affichecustomer")
	public List<Customer> Teste()throws Exception  
	{
return customerRepository.findAll().stream().filter(c -> c.getPoints() < 100 && c.getName().startsWith("Charles")).collect(Collectors.toList());
	}
	
	@PostMapping(value="/presonnesave")
	public void savePersonne(@RequestBody Personne personne)throws Exception  
	{

		ipersonne.save(personne);

	}
	
	@GetMapping(value="/personneget")
	public List<Personne>  getPersonne()throws Exception  
	{

	return ipersonne.findAll();

	}
	
@GetMapping(value="/personnetresam")
public double getlesPersonne()
{
//	 long total = 0;
//	    int nbPers = 0;
//	    for (Personne personne : ipersonne.findAll()) {
//	      if (personne.getGenre() == false) {
//	        nbPers++;
//	        total += personne.getTaille();
//	      }
//	    }
//	    double resultat = (double) total / nbPers;
//	    System.out.println("Taille moyenne des femmes = " + resultat);
	    
	double resultat = ipersonne.findAll()
		      .stream()
		      .filter(p -> p.getGenre() == false)
		      .mapToInt(p -> p.getTaille())
		      .average()
		      .getAsDouble();
	
	    return resultat;
	    
}
	
@GetMapping(value="/personnestre")
public List<String> gettriesPersonne()
{
	
	   List<Personne> employeMasculins = new ArrayList<>();
//	   
//	    for (Personne e : ipersonne.findAll()) {
//	      if (e.getGenre() == true) {
//	        employeMasculins.add(e);
//	      }
//	    }
//	    
//	    Collections.sort(employeMasculins, new Comparator<Personne>() {
//	        @Override
//	        public int compare(Personne p1, Personne p2) {
//	          return p2.getTaille() - p1.getTaille();
//	        }
//	      });
//	    
//	    System.out.println(employeMasculins);
//	    List<String> nomEmployes = new ArrayList<>();
//	    for (Personne p : employeMasculins) {
//	      nomEmployes.add(p.getName());
//	    }
	   
	   List<String> nomEmployes = 
			   ipersonne.findAll().stream()
			              .filter(e -> e.getGenre() ==true)
			              .sorted(Comparator.comparingInt(Personne::getTaille)
			                                .reversed())
			              .map(Personne::getName)
			              .collect(Collectors.toList());

			  
	    return nomEmployes;
}

}
