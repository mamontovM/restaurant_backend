package ru.relex.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.relex.security.filters.JwtAccessFilter;
import ru.relex.security.filters.JwtRefreshFilter;
import ru.relex.security.filters.RestaurantAuthFilter;
import ru.relex.security.service.ITokenService;
import ru.relex.security.service.RestaurantUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@Configuration
public class RestaurantSecurityConfig extends WebSecurityConfigurerAdapter {
  private final RestaurantUserDetailsService restaurantUserDetailsService;
  private final AuthenticationSuccessHandler successHandler;
  private final ITokenService tokenService;

  public RestaurantSecurityConfig(RestaurantUserDetailsService restaurantUserDetailsService, AuthenticationSuccessHandler successHandler, ITokenService tokenService) {
    this.restaurantUserDetailsService = restaurantUserDetailsService;
    this.successHandler = successHandler;
    this.tokenService = tokenService;
  }


  @Override
  protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(restaurantUserDetailsService);
    auth.authenticationProvider(provider);
    super.configure(auth);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    var passwordEncoder = new Pbkdf2PasswordEncoder("", 185000, 512);
    passwordEncoder.setEncodeHashAsBase64(true);
    return passwordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    var filter = new RestaurantAuthFilter(successHandler, authenticationManager());
    http
        .csrf().disable()
        .cors().disable()
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(filter)
        .addFilterBefore(new JwtAccessFilter(authenticationManager(), tokenService), RestaurantAuthFilter.class)
        .addFilterBefore(new JwtRefreshFilter(authenticationManager(), tokenService), JwtAccessFilter.class);
  }

}
