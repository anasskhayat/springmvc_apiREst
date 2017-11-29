package springbootApiRest.example.api.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootApiRest.example.api.rest.model.Cita;
import springbootApiRest.example.api.rest.model.Empleado;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	List<Empleado> repo;

	@GetMapping("/empleado")

	public List<Empleado> list() {
		return repo;
	}

	@GetMapping("/empleado/{id}")
	public Empleado getEmpleado(@PathVariable long id) {
		if (id > 0 && repo.size() >= id) {
			return repo.get((int) (id - 1));
		}
		return null;
	}

	@GetMapping("/empleado/{id}/citas")

	public List<Cita> getIdcitaempleado(@PathVariable long id) {

		if (0 < id && id <= repo.size()) {
			return repo.get((int) (id - 1)).getCitas();
		}

		return null;
	}

	@GetMapping("/empleado/{idE}/cita/{idC}")
	public Cita getCitaEmpleado(@PathVariable Long idE, @PathVariable Long idC) {
		Cita result = null;
		if (idE > 0 && idE <= repo.size()) {
			List<Cita> citas = repo.get((int) (idE - 1)).getCitas();
			if (citas != null) {
				for (Cita c : citas)
					if (c.getId() == idC)
						result = c;
			}
		}
		return result;
	}

	@PostConstruct
	private void init() {
		repo = new ArrayList<Empleado>();

		repo.add(new Empleado(1L, "Pepe", "Gotera", new Date()));
		repo.get(0).getCitas().add(new Cita(1L, "Reunión de trabajo", new Date()));
		repo.get(0).getCitas().add(new Cita(2L, "Visita a un cliente", new Date()));

		repo.add(new Empleado(2L, "Otilio", "García", new Date()));
		repo.get(1).getCitas().add(new Cita(3L, "Visita a un proveedor", new Date()));

		repo.add(new Empleado(3L, "Mortadelo", "Gómez", new Date()));
		repo.add(new Empleado(4L, "Filemón", "Guzmán", new Date()));
		repo.add(new Empleado(5L, "Super", "López", new Date()));
	}

}
