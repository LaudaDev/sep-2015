package app.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;
	private static final Logger logger = Logger.getLogger(MailSenderService.class);

	public void send(String message, String recipient, String customerName) {
		// Prepare the evaluation context

		MimeMessage mail = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);

			helper.setTo(recipient);
			helper.setSubject("Confirmation message");
			
			helper.setText("Dear " +  customerName+ "," +
					"\n\n\n"+message+"\n\n\nKind regards, \nInsurance App - Team 18");
			
			helper.addInline("myLogo", new ClassPathResource("images/businessCard.png"));

		} catch (MessagingException e) {
			logger.error("Messaging exception");
			e.printStackTrace();
		}
		{
		}
		javaMailSender.send(mail);
		logger.info("e-mail has been successfully sent");

	}

}
