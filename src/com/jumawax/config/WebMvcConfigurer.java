package com.jumawax.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumawax.helper.SaltHasher;
import java.sql.SQLException;
import java.util.Arrays;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.jumawax"})
public class WebMvcConfigurer
  extends WebMvcConfigurerAdapter
{
  public void addResourceHandlers(ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler(new String[] { "/resources/**" }).addResourceLocations(new String[] { "/resources/" });
  }
  
  public void addViewControllers(ViewControllerRegistry registry)
  {
    registry.addViewController("/").setViewName("index");
  }
  
  @Bean
  public InternalResourceViewResolver viewResolver()
  {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
  
  @Bean(name={"ds"}, destroyMethod="")
  public DataSource dataSource()
  {
    JndiDataSourceLookup dsLookUp = new JndiDataSourceLookup();
    DataSource dataSource = dsLookUp.getDataSource("java:comp/env/jdbc/JumawaxDS");
    try
    {
      dataSource.getConnection();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return dataSource;
  }
  
  @Bean(name={"hash"})
  public static SaltHasher hasher()
  {
    SaltHasher sh = new SaltHasher();
    return sh;
  }
  
  @Bean
  public ObjectMapper jacksonObjectMapper()
  {
	ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return objectMapper;
  }
  
  @Bean
  public MappingJackson2HttpMessageConverter jsonConverter()
  {
    MappingJackson2HttpMessageConverter jacksonConverter = 
      new MappingJackson2HttpMessageConverter();
    jacksonConverter.setSupportedMediaTypes(Arrays.asList(new MediaType[] { MediaType.valueOf("application/javascript") }));
    jacksonConverter.setObjectMapper(jacksonObjectMapper());
    return jacksonConverter;
  }
}
