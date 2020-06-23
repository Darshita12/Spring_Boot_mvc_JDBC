package com.controller;

import com.bean.UserBean;
import com.controller.EmailService;
import com.controller.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
//@Controller
/*
 * @RequestMapping("api/send/mail")
 * 
 * @CrossOrigin("*")
 */
public class MailRestController {

	@Autowired
    private EmailService mailService;


	@PostMapping("/sendmail")
    public ResponseEntity<?> sendMail(@Valid @RequestBody Mail mail, Errors errors,HttpServletRequest request){
    	String email=request.getParameter("email");
    	mail.setEmail(email);
    	if(errors.hasErrors()){
            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return mailService.sendMail(mail);
    }
	/*
	 * @PostMapping("/sendmail") public String sendMail(@Valid @RequestBody Mail
	 * mail, Errors errors,UserBean userBean,HttpServletRequest request) { String
	 * email=request.getParameter("email"); userBean.setEmail(email);
	 * if(errors.hasErrors()){ return new ResponseEntity<>(errors.getAllErrors(),
	 * HttpStatus.BAD_REQUEST); } return mailService.sendMail(mail);
	 * userBean=userDao.frgtpwd(userBean);
	 * 
	 * }
	 */
}
