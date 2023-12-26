package org.odusseus.Defteros;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingletonBeanConfig {
  
  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public EventDAO eventDAO() {
      return new EventDAO();
  }

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public EventsDAO eventsDAO() {
      return new EventsDAO();
  }
}
