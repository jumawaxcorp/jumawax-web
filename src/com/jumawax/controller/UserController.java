package com.jumawax.controller;

import com.jumawax.jdbc.UserCC;
import com.jumawax.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.servlet.ServletException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"user"})
public class UserController
{
  private static Logger log = Logger.getLogger(UserController.class);
  @Autowired
  UserCC userCC;
  
  @RequestMapping(value={"login"}, produces={"application/json"})
  @ResponseBody
  public User login(String username, String password)
    throws ServletException
  {
    log.debug("Obus Kirim=" + username + "&" + password);
    User usr = new User();
    usr = this.userCC.login(username, password);
    usr.setMsg("Success");
    
    String role = usr.getRole();
    if (role.equals("")) {
        usr.setMsg("Invalid Username Password");
    }
    usr.setToken(Jwts.builder().setSubject(usr.getAgentname()).claim("roles", role).setIssuedAt(new Date())
      .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
    
    return usr;
  }
}
