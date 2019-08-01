package ru.relex.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import ru.relex.security.currentUserUtils.CurrentUser;
import ru.relex.security.currentUserUtils.MapperCurrentUser;


@Configuration
public class CurrentUserProviderConfig {

  private static final Logger logger = LoggerFactory.getLogger(CurrentUserProviderConfig.class);

  @Bean
  @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
  CurrentUser getCurrentUser(MapperCurrentUser mapper) {
    var principal = SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

    if (principal == null) {
      throw new NullPointerException("User not found");
    }

    return  mapper.toUser(principal.toString());
  }
}
