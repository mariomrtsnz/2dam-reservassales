package salesianos.triana.dam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesianos.triana.dam.model.Authorities;
import salesianos.triana.dam.repository.AuthoritiesRepository;

@Service
public class AuthoritiesService {
	@Autowired
	AuthoritiesRepository repositorio;
	
	public Authorities save(Authorities authority) {
		return repositorio.save(authority);
	}
	
}
