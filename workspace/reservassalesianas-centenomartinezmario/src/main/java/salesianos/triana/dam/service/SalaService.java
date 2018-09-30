package salesianos.triana.dam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesianos.triana.dam.model.Sala;
import salesianos.triana.dam.repository.SalaRepository;

@Service
public class SalaService {
	@Autowired
	SalaRepository repositorio;

	public Sala findOneById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	public Iterable<Sala> findAll() {
		return repositorio.findAll();
	}

	public Sala save(Sala entidad) {
		return repositorio.save(entidad);
	}

	public Sala remove(Sala entidad) {
		Sala salaABorrar = findOneById(entidad.getId());
		if (salaABorrar != null)
			repositorio.delete(entidad);
		return salaABorrar;
	}

	public void edit(Sala entidad) {
		save(entidad);
	}

}
