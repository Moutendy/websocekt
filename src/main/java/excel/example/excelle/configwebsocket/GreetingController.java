package excel.example.excelle.configwebsocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.excelle.model.HelloMessage;
import excel.example.excelle.repositories.MessageRepository;

@RestController
public class GreetingController {

	@Autowired
	MessageRepository messagerepository;
	
	@Autowired
	NotificationService notificationService;
	
	@MessageMapping(value="/hello")
	@SendTo("/topic/greetings")
	@GetMapping(value="/receptionmessage")
	public List<HelloMessage> greet()
	{
		return messagerepository.findAll();
	}
	
	
	@MessageMapping(value="/envoimessagenotification")
	@SendTo("/topic/greetings")
	@PostMapping(value="/envoimessage")
	public void send(@RequestBody String nom)throws Exception  
	{
		HelloMessage message = new HelloMessage();
		notificationService.sendGlobalNotification();
		message.setName(nom);
		messagerepository.save(message);

	}
	
	
	
	

}
