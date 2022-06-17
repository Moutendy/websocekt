package excel.example.excelle.configwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import excel.example.excelle.model.Personne;
import excel.example.excelle.repositories.INotificationRepository;



@RestController
@EnableScheduling
public class NotificationController {
	
	@Autowired
	INotificationRepository notificationRepository;

	@Autowired
	private SimpMessagingTemplate template;

	@Scheduled(fixedRate = 1000)
	public void countNotificationsUser() throws Exception {
		Personne user = new Personne();

		user.setId(Long.valueOf(1));
		this.template.convertAndSend("/topic/notifUser",
				notificationRepository.countByDestinationPersonneAndIsReadByPersonne(user, false));
	}
	


}
