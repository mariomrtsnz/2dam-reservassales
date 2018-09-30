package salesianos.triana.dam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import salesianos.triana.dam.model.Authorities;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.service.AuthoritiesService;
import salesianos.triana.dam.service.UsuarioService;

@SpringBootApplication
public class ReservassalesianasCentenomartinezmarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservassalesianasCentenomartinezmarioApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner insertInitialData(UsuarioService usuarioService, AuthoritiesService authoritiesService) {
//		return args -> {
//			Usuario usuario = new Usuario("usuario@usuario.com", "$2a$04$Kl8L17nXNhC1Rfr/z2aGjuo8XOQUVS.ZYUcHdDUOVX26XN1ru263G", "Usuario", "111222333", true);
//			usuarioService.save(usuario);
//			Usuario admin = new Usuario("admin@admin.com", "$2a$04$r8Ar8dyS0gfybPUSg825aOZYg4/41vXwcvQGVe5.bOCOxyQh1I3eu", "Admin", "444555666", true);
//			usuarioService.save(admin);
//			
//			Authorities authorityUser = new Authorities("ROLE_USUARIO", usuario);
//			authoritiesService.save(authorityUser);
//			Authorities authorityAdmin = new Authorities("ROLE_ADMIN", admin);
//			authoritiesService.save(authorityAdmin);
//		};
//	}
}
