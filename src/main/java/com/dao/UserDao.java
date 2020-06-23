package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
 
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.boot.rsocket.server.RSocketServer.Transport;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public int addUser(UserBean userBean)
	{
		return jdbcTemplate.update("insert into usermvc(firstname,lastname,email) values('"+userBean.getFirstName()+"','"+userBean.getLastName()+"','"+userBean.getEmail()+"')");
	}
	private final static class UserMapper implements RowMapper<UserBean>
	{

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			UserBean userBean=new UserBean();
			userBean.setFirstName(rs.getString("firstname"));
			userBean.setLastName(rs.getString("lastname"));
			userBean.setId(rs.getInt("id"));
			userBean.setEmail(rs.getString("email"));
			return userBean;
		}
		
	}
	public List<UserBean> getData()
	{
		return jdbcTemplate.query("select * from usermvc",new UserMapper());
	}
	public int deleteUser(int id)
	{
		return jdbcTemplate.update("delete from usermvc where id="+id+"");
	}
	public int updateUser(UserBean userBean)
	{
		return jdbcTemplate.update("update usermvc set firstname='"+userBean.getFirstName()+"',lastname='"+userBean.getLastName()+"',email='"+userBean.getEmail()+"'");
	}
	/*public UserBean frgtpwd(UserBean userBean)
	{
		String sql = "select * from usermvc where id='" + userBean.getEmail()+ "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<UserBean>() {

			
			 * @Override
			  public UserBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserBean userBean = new UserBean();
				if (rs.next()) {

					userBean.setFirstName(rs.getString("firstname"));
					userBean.setLastName(rs.getString("lastname"));
					userBean.setId(rs.getInt("id"));

				}

				return userBean;
			}

		});
	}
	public static void send(String to,int id) 
	{

		
		final String user = "darshi6936@gmail.com";
		final String pass = "9924013130";
		
		//2 stpe of varification
		//less secure app ..on
		
		
		

		Properties props = new Properties();
		//smtp http
		
		
		props.put("mail.smtp.host", "smtp.gmail.com");//gmail //protocol
		props.put("mail.smtp.auth", "true");
		

		props.put("mail.smtp.user", user);
		props.put("mail.smtp.password", pass);

		
		props.put("mail.smtp.port", 587);
		//
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		
		props.put("mail.smtp.starttls.enable", "true");//stateless protocol
		props.put("mail.smtp.EnableSSL.enable", "true");
		

	
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication() {
				//password...
				return new PasswordAuthentication(user, pass);
			}
		});
		
		
		System.out.println("----------------------");
		
		try 
		{
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			  message.setSubject("Reset Password");
			  message.setText("Go through this link http://localhost:8080/Final_project/ResetPwd.jsp?id="+id+" and enter this id"+id);
			 

			
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) 
		{
			throw new RuntimeException(e);
		}

	}*/

}
