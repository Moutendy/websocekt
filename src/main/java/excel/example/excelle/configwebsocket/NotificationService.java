package excel.example.excelle.configwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

import excel.example.excelle.repositories.MessageRepository;

@RestController
@EnableScheduling
public class NotificationService {
	@Autowired
	MessageRepository messageRepository;
	
	
	
	
	
	public void sendNotification() 
	{
		
		
	}
	
}
