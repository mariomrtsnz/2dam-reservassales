package salesianos.triana.dam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off

				http
					.authorizeRequests()
					.antMatchers("/**").permitAll()
					.antMatchers("/styles/**").permitAll()
					.antMatchers("/scripts/**").permitAll()
					.antMatchers("/images/**").permitAll()
					.antMatchers("/h2-console/**").permitAll()
					.antMatchers("/registro").permitAll()
					.antMatchers("/login").permitAll() // Para permitir el acceso al formulario de login
					.anyRequest().authenticated() // El resto de peticiones, autenticadas.
					.and()
					.formLogin() 
						.loginPage("/login") // Ruta del controlador del formulario de login
						.defaultSuccessUrl("/home") // Ruta de redirección en caso de éxito.
						.loginProcessingUrl("/login") // Ruta de procesamiento del formulario de login.
						.failureUrl("/login?error=true") // Ruta en caso de error de login.
					.and()
					.logout().logoutSuccessUrl("/login?logout"); // por defecto POST a /logout
				
				http.csrf().disable();
				http.headers().frameOptions().disable();

				// @formatter:on
    }
	
}
