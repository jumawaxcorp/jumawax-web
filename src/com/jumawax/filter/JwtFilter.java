package com.jumawax.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter
  extends GenericFilterBean
{
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest)req;
    
    String authHeader = request.getHeader("Authorization");
    if ((authHeader == null) || (!authHeader.startsWith("Jmw "))) {
      throw new ServletException("Missing or invalid Authorization header.");
    }
    String token = authHeader.substring(3);
    try
    {
      Claims claims = 
        (Claims)Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
      request.setAttribute("claims", claims);
    }
    catch (SignatureException e)
    {
      throw new ServletException("Invalid token.");
    }
    chain.doFilter(req, res);
  }
}
