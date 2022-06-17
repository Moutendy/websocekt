package excel.example.excelle.configwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import excel.example.excelle.model.HelloMessage;
import excel.example.excelle.repositories.MessageRepository;

@Service
public class NotificationService {
   
	@Autowired
	private  SimpMessagingTemplate messageTemple;
	
	@Autowired
	MessageRepository messageRepository;
	
	public void sendGlobalNotification()
	{
		HelloMessage message = new HelloMessage();
		message.setName("bonjour a toi");
		messageTemple.convertAndSend("/topic/greetings ",messageRepository.countByDestinationUserAndIsReadByUser(null, null));
	}
	
	
	public void sendPrivateNotification()
	{
		HelloMessage message = new HelloMessage();
		message.setName("bonjour a toi");
		messageTemple.convertAndSend("/topic/message-private",messageRepository.save(message));
	}
	
	
	
}
