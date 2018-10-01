package salesianos.triana.dam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import salesianos.triana.dam.model.Authorities;
import salesianos.triana.dam.model.Reserva;
import salesianos.triana.dam.model.Sala;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.service.AuthoritiesService;
import salesianos.triana.dam.service.ReservaService;
import salesianos.triana.dam.service.SalaService;
import salesianos.triana.dam.service.UsuarioService;

@SpringBootApplication
public class ReservassalesianasCentenomartinezmarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservassalesianasCentenomartinezmarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertInitialData(UsuarioService usuarioService, AuthoritiesService authoritiesService,
			SalaService salaService, ReservaService reservaService) {
		return args -> {
			Usuario usuario = new Usuario("usuario@usuario.com",
					"$2a$04$Kl8L17nXNhC1Rfr/z2aGjuo8XOQUVS.ZYUcHdDUOVX26XN1ru263G", "Usuario", "111222333", true);
			usuarioService.save(usuario);
			Usuario usuario2 = new Usuario("usuario2@usuario2.com",
					"$2a$04$hDkpDSmANf7Ho8hNl/LqE.QFm/A4ZVm5vLSMVcyKgw2lgQ8OjnN3i", "Usuario2", "777888999", false);
			usuarioService.save(usuario2);
			Usuario admin = new Usuario("admin@admin.com",
					"$2a$04$r8Ar8dyS0gfybPUSg825aOZYg4/41vXwcvQGVe5.bOCOxyQh1I3eu", "Admin", "444555666", true);
			usuarioService.save(admin);

			Authorities authorityUser = new Authorities("ROLE_USUARIO", usuario);
			authoritiesService.save(authorityUser);
//			Authorities authorityUser2 = new Authorities("ROLE_USUARIO", usuario2);
//			authoritiesService.save(authorityUser2);
			Authorities authorityAdmin = new Authorities("ROLE_ADMIN", admin);
			authoritiesService.save(authorityAdmin);

			Sala sala1 = new Sala("Biblioteca", 150);
			salaService.save(sala1);
			Sala sala2 = new Sala("Salón de actos", 300);
			salaService.save(sala2);

			Reserva reserva1 = new Reserva(LocalDateTime.of(LocalDate.of(2018, 12, 30), LocalTime.of(10, 00)),
					LocalDateTime.of(LocalDate.of(2018, 12, 30), LocalTime.of(12, 00)), usuario, sala1);
			reservaService.save(reserva1);

			Reserva reserva2 = new Reserva(LocalDateTime.of(LocalDate.of(2018, 12, 18), LocalTime.of(17, 30)),
					LocalDateTime.of(LocalDate.of(2018, 12, 18), LocalTime.of(20, 00)), usuario2, sala2);
			reservaService.save(reserva2);
		};
	}
}
