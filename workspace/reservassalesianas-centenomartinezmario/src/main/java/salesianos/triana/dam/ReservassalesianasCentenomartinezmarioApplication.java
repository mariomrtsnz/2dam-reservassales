package salesianos.triana.dam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import salesianos.triana.dam.model.Authorities;
import salesianos.triana.dam.model.Reserva;
import salesianos.triana.dam.model.ReservaEvento;
import salesianos.triana.dam.model.Sala;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.service.AuthoritiesService;
import salesianos.triana.dam.service.ReservaEventoService;
import salesianos.triana.dam.service.ReservaService;
import salesianos.triana.dam.service.SalaService;
import salesianos.triana.dam.service.UsuarioService;

@SpringBootApplication
public class ReservassalesianasCentenomartinezmarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservassalesianasCentenomartinezmarioApplication.class, args);
	}
}
