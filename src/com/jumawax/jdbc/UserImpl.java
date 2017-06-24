package com.jumawax.jdbc;

import com.jumawax.helper.SaltHasher;
import com.jumawax.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserImpl
  implements UserCC
{
  @Autowired
  @Qualifier("ds")
  private DataSource ds;
  @Autowired
  @Qualifier("hash")
  private SaltHasher sh;
  
  public void setDs(DataSource ds)
  {
    this.ds = ds;
  }
  
  Logger log = Logger.getLogger(UserImpl.class);
  
  public User login(String username, String password)
  {
    String hashedPassword = SaltHasher.hashPassword(username, password);
    Connection con = null;
    User user = new User();
    String query = "SELECT * FROM USER WHERE USERNAME = '" + username + "'" + " AND PASSWORD = '" + hashedPassword + "'";
    log.debug("query= "+query);
    try
    {
      con = this.ds.getConnection();
      Statement statement = con.createStatement();
      ResultSet rs = statement.executeQuery(query);
      if (rs.next())
      {
        user.setAgentname(rs.getString("agent_name"));
        user.setRole(rs.getString("role_id"));
        user.setUsername(rs.getString("username"));
      }
      rs.close();
      con.close();
    }
    catch (Exception localException) {}
    return user;
  }
}
