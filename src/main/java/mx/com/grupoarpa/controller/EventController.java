package mx.com.grupoarpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.grupoarpa.entity.Artist;
import mx.com.grupoarpa.entity.Event;
import mx.com.grupoarpa.entity.FairGround;
import mx.com.grupoarpa.repository.ArtistRepository;
import mx.com.grupoarpa.repository.EventRepository;
import mx.com.grupoarpa.repository.FairgroundRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/v1/api/events")
@EnableSwagger2
@CrossOrigin(origins = "*")
public class EventController {
	
	@Autowired
	EventRepository eventRepo;
	
	@Autowired
	ArtistRepository artisRepo;
	
	@Autowired
	FairgroundRepository fairRepo;
	
	@GetMapping()
	public ResponseEntity<?> getEventList(){
		List<Event> list = eventRepo.findAll();
		if(list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(list);
		}
		
	}
	
	@GetMapping("/{idEvent}")
	public ResponseEntity<?> getEvent(@PathVariable String idEvent){
		Optional<Event> event = eventRepo.findById(idEvent);
		if(event.isPresent()) {
			return ResponseEntity.ok(event);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping()
	public ResponseEntity<?> addEvent(@RequestBody Event event){
		event.getArtistas().stream().forEach(artist ->{
			if(artist.getId() == null) {
				Artist artisAdded = artisRepo.save(artist);
				artist.setId(artisAdded.getId());
			}
		});
		
		if(event.getFairGround().getId() == null) {
			FairGround fairGGroundSave = fairRepo.save(event.getFairGround());
			event.getFairGround().setId(fairGGroundSave.getId());
		}
		return ResponseEntity.ok(eventRepo.save(event));
	}
	
	@PutMapping()
	public ResponseEntity<?> updateEvent(@PathVariable String idEvent, @RequestBody Event event ){
		return null;
	}
	
	@DeleteMapping("/{idEvent}")
	public ResponseEntity<?> deleteEvent(@PathVariable String idEvent){
		return null;
	}

}
