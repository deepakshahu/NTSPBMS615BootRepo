package com.nit.service;

import java.util.Arrays;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("shopping")
public class ShoppingServiceImpl implements IShopping{

	@Autowired
	private JavaMailSender sender;
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Override
	public String shopping(String[] items, float[] prices, String[] toMails) throws Exception {
		float billAmt = 0.0f;
		for(float p:prices) {
			billAmt = billAmt+p;
		}
		String message = "The items "+Arrays.toString(items)+" with prices "+Arrays.toString(prices)+" are purchased having bill amount :: "+billAmt;
		//trigger email message
		String status = sendMail(message, "Shopping details", toMails);
		return message+"========"+status;
	}
	
	private String sendMail(String body, String subject, String[] toMails) throws Exception{
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setFrom(fromMail);
		helper.setCc(toMails);
		helper.setSubject(subject);
		helper.setSentDate(new Date());
		helper.setText(body);
		helper.addAttachment("nit.png", new ClassPathResource("nit_logo.png"));  //place this nit_logo.png file in src/main/resources folder
		sender.send(message);
		return "Mail with attachment is send";
		
	}

}
