package springboot.psp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot.psp.entity.Actividad;
import springboot.psp.repository.ActividadRepository;

@Service
public class ActividadService {
	@Autowired
	private ActividadRepository actividadRepository;
	
	// RQFUNCIONAL: 1b "Consultar las actividades disponibles y su información"
	public List<Actividad>findAll(){
		return actividadRepository.findAll();
	}
	// Metodo de apollo para el resto de clases
	public Optional<Actividad>findById(int id){
		return actividadRepository.findById(id);
	}
	
	//RQFUNCIONAL: 4b "Crear actividades"
	public Actividad create(Actividad a) {
		return actividadRepository.save(a);
	}
	
	//RQFUNCIONAL: 4b “Administrar las jornadas, pudiendo crearlas, consultarlas, modificarlas y eliminarlas.”
	@Transactional
	public Actividad update(Actividad nueva, int idActividad) {
		Optional<Actividad> actividadOpt=findById(idActividad);
		if(actividadOpt.isPresent()) {
			Actividad vieja = actividadOpt.get();
			
			vieja.setNombre(nueva.getNombre());
			vieja.setDescripcion(nueva.getDescripcion());
			vieja.setFecha(nueva.getFecha());
			vieja.setHoraInicio(nueva.getHoraInicio());
			vieja.setHoraFinalizacion(nueva.getHoraFinalizacion());
			vieja.setUbicacion(nueva.getUbicacion());
			vieja.setMaximosParticipantes(nueva.getMaximosParticipantes());
			vieja.setEstadoActividad(nueva.getEstadoActividad());
			
			return actividadRepository.save(vieja);
		}
		return null;
		
	}
	//RQFUNCIONAL: 4b "Administrar las jornadas, pudiendo crearlas, consultarlas, modificarlas y eliminarlas."
	@Transactional
	public boolean delete(int idActividad) {
		if(actividadRepository.existsById(idActividad)) {
			actividadRepository.deleteById(idActividad);
			return true;
		}
		return false;
	}
	
	
}
