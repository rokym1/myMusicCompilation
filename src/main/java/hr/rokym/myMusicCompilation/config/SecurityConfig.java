package hr.rokym.myMusicCompilation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/artistDetails/showDetails").permitAll()
			.antMatchers("/artistDetails/showFormForUpdateDetails").hasRole("ADMIN")
			.antMatchers("/artistDetails/update").hasRole("ADMIN")
			.antMatchers("/artists/showFormForAddArtist").hasRole("ADMIN")
			.antMatchers("/artists/save").hasRole("ADMIN")
			.antMatchers("/artists/showFormForUpdateArtist").hasRole("ADMIN")
			.antMatchers("/artists/delete").hasRole("ADMIN")
			.antMatchers("/artists/**").hasAnyRole("USER", "ADMIN")
			.antMatchers("/albums/showFormForAddAlbum").hasRole("ADMIN")
			.antMatchers("/albums/save").hasRole("ADMIN")
			.antMatchers("/albums/showFormForUpdateAlbum").hasRole("ADMIN")
			.antMatchers("/albums/delete").hasRole("ADMIN")
			.antMatchers("/albums/**").hasAnyRole("USER", "ADMIN")
			.antMatchers("/songs/showFormForAddSong").hasRole("ADMIN")
			.antMatchers("/songs/save").hasRole("ADMIN")
			.antMatchers("/songs/delete").hasRole("ADMIN")
			.antMatchers("/songs/**").hasAnyRole("USER", "ADMIN")
			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
}











