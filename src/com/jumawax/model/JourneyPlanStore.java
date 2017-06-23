package com.jumawax.model;

public class JourneyPlanStore
{
  private String planId;
  private String storeCode;
  private String storeName;
  private String address;
  private String name;
  private String phonenumber;
  private String email;
  
  
  public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhonenumber() {
	return phonenumber;
}

public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

private String latitude;
  private String longitude;
  private String isReached;
  
  public String getPlanId()
  {
    return this.planId;
  }
  
  public void setPlanId(String planId)
  {
    this.planId = planId;
  }
  
  public String getStoreCode()
  {
    return this.storeCode;
  }
  
  public void setStoreCode(String storeCode)
  {
    this.storeCode = storeCode;
  }
  
  public String getStoreName()
  {
    return this.storeName;
  }
  
  public void setStoreName(String storeName)
  {
    this.storeName = storeName;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public String getLatitude()
  {
    return this.latitude;
  }
  
  public void setLatitude(String latitude)
  {
    this.latitude = latitude;
  }
  
  public String getLongitude()
  {
    return this.longitude;
  }
  
  public void setLongitude(String longitude)
  {
    this.longitude = longitude;
  }
  
  public String getIsReached()
  {
    return this.isReached;
  }
  
  public void setIsReached(String isReached)
  {
    this.isReached = isReached;
  }
}
