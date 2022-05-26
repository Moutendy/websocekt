package excel.example.excelle.configwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import excel.example.excelle.model.HelloMessage;

@Service
public class NotificationService {
   
	@Autowired
	private  SimpMessagingTemplate messageTemple;
	
	public void sendGlobalNotification()
	{
		HelloMessage message = new HelloMessage();
		message.setName("bonjour a toi");
		messageTemple.convertAndSend("/topic/greetings ",message);
	}
	
	
	public void sendPrivateNotification()
	{
		HelloMessage message = new HelloMessage();
		message.setName("bonjour a toi");
		messageTemple.convertAndSend("/topic/message-private",message);
	}
	
	
	
}
