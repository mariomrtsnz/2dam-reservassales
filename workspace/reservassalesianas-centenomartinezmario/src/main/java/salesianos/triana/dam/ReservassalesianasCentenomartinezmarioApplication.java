package salesianos.triana.dam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import salesianos.triana.dam.service.UsuarioService;

@SpringBootApplication
public class ReservassalesianasCentenomartinezmarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservassalesianasCentenomartinezmarioApplication.class, args);
	}
	
//	public CommandLineRunner insertInitialData(UsuarioService usuarioService) {
//		return args -> {
//			Usuario usuario = new Usuario();
//		};
//	}
}
