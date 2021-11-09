package mx.com.grupoarpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.com.grupoarpa.entity.Artist;
import mx.com.grupoarpa.repository.ArtistRepository;

@Slf4j
@RestController
@RequestMapping("/api/artists")
public class ArtistController {
	
	//private String EVENT_SERVICE="http://events-service/";
	
	
	
	@Autowired
	ArtistRepository artisRepo;
	
	@Value("${user.role}")
	private String role;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	@GetMapping()
	public ResponseEntity<?> getArtistList(){
		List<Artist> list = artisRepo.findAll();
		log.trace(role);
		if(list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(list);
		}
		
	}
	
	@GetMapping("/{idArtist}")
	public ResponseEntity<?> getArtist(@PathVariable String idArtist){
		return null;
	}
	
	@PostMapping()
	public ResponseEntity<?> addArtist(@RequestBody Artist artist){
		return ResponseEntity.ok(artisRepo.save(artist));
	}
	
	@PutMapping()
	public ResponseEntity<?> updateArtist(@PathVariable String idArtist, @RequestBody Artist event ){
		return null;
	}
	
	@DeleteMapping("/{idArtist}")
	public ResponseEntity<?> deleteArtistById(@PathVariable String idArtist){
		return null;
	}
	
	

}
