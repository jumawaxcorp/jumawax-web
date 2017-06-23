package com.jumawax.model;

public class User
{
  private String role;
  private String agentname;
  private String token;
  private String username;
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setToken(String token)
  {
    this.token = token;
  }
  
  public String getRole()
  {
    return this.role;
  }
  
  public void setRole(String role)
  {
    this.role = role;
  }
  
  public String getAgentname()
  {
    return this.agentname;
  }
  
  public void setAgentname(String agentname)
  {
    this.agentname = agentname;
  }
}
