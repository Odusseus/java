package org.odusseus.Defteros.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import org.odusseus.Defteros.dao.EventsDAO;
import org.odusseus.Defteros.dao.PersonsDAO;

@Configuration
public class SingletonBeanConfig {
  
  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public EventsDAO eventsDAO() {
      return new EventsDAO();
  }

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public PersonsDAO personsDAO() {
      return new PersonsDAO();
  }
}
