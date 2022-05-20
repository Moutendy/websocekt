package excel.example.excelle.configwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class GreetingController {

	@MessageMapping(value="/hello")
	@SendTo("/topic/greetings")
	public Greeting greet( HelloMessage message)
	{
		return new Greeting("Bonjour toi,"+ HtmlUtils.htmlEscape(message.getName()));
	}
	

}
