package com.jumawax.helper;

import org.apache.commons.codec.digest.DigestUtils;

public class SaltHasher
{
  private static final String SECRET_KEY = "jumawa";
  
  public static String hashPassword(String username, String rawPassword)
  {
    String hashed = DigestUtils.sha1Hex(username + rawPassword + SECRET_KEY);
    return hashed;
  }
}
