package excel.example.excelle.configwebsocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excel.example.excelle.model.Message;
import excel.example.excelle.repositories.MessageRepository;

@RestController
public class ControllerMessage {
	@Autowired
	MessageRepository messagerepository;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/hello")
//    @SendTo("/topic/greetings")
    public List<Message> greeting(@RequestBody Message message) throws Exception {
		
    
        this.template.convertAndSend("/topic/greetings",
        		messagerepository.findAll());
        
        return null; 
    }

	
}
