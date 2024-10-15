package com.codeWithMe.Uber.Uber;

import com.codeWithMe.Uber.Uber.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

//	@Test
//	void contextLoads() {
//		emailSenderService.sendEmail("soyaka9669@hapied.com"
//		, "This is the testing email"
//		, "Body of my email");
//	}
//
//	@Test
//	void sendEmailMultiple(){
//
//		String[] emails = {
//				"tebosat139@inpsur.com",
//				"fobice4289@kwalah.com",
//				"deepakkumarmaurya688@gmail.com"
//		};
//		emailSenderService.sendEmail(emails, "Hello everyOne from my application",
//				"This is body , do Coding to enhance skills"
//				);
//	}


}
