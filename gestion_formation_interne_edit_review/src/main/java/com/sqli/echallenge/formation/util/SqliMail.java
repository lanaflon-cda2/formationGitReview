/**
 * 
 */
package com.sqli.echallenge.formation.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author Mouad
 *
 */
public class SqliMail {
	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String text, String mailTo, String dear, String content) {
		SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
		
		message.setTo(mailTo);
		message.setText(String.format(text, dear, content));
		
		mailSender.send(message);	
	}
}
