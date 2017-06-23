package com.jumawax.model;

public class JourneyPlan
{
  private String planId;
  private String submitDate;
  private String agent;
  private String owner;
  private String status;
  
  public String getPlanId()
  {
    return this.planId;
  }
  
  public void setPlanId(String planId)
  {
    this.planId = planId;
  }
  
  public String getSubmitDate()
  {
    return this.submitDate;
  }
  
  public void setSubmitDate(String submitDate)
  {
    this.submitDate = submitDate;
  }
  
  public String getAgent()
  {
    return this.agent;
  }
  
  public void setAgent(String agent)
  {
    this.agent = agent;
  }
  
  public String getOwner()
  {
    return this.owner;
  }
  
  public void setOwner(String owner)
  {
    this.owner = owner;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
}
