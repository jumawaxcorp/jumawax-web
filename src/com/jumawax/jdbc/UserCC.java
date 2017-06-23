package com.jumawax.jdbc;

import com.jumawax.model.User;
import org.springframework.stereotype.Component;

@Component
public abstract interface UserCC
{
  public abstract User login(String paramString1, String paramString2);
}
