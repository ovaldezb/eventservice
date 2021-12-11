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

import mx.com.grupoarpa.entity.FairGround;
import mx.com.grupoarpa.repository.FairgroundRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/v1/api/fairgrounds")
@EnableSwagger2
@CrossOrigin(origins = "*")
public class FairgroundController {
	
	@Autowired
	FairgroundRepository fairRepo;
	
	@GetMapping()
	public ResponseEntity<?> getFairGroundList(){
		List<FairGround> list = fairRepo.findAll();
		//log.trace(role);
		if(list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(list);
		}
		
	}
	
	@GetMapping("/{idFairGround}")
	public ResponseEntity<?> getFairGround(@PathVariable String idFairGround){
		Optional<FairGround> fairGroundFound = fairRepo.findById(idFairGround); 
		if(fairGroundFound.isPresent()) {
			return ResponseEntity.ok(fairGroundFound.get());	
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping()
	public ResponseEntity<?> addFairGround(@RequestBody FairGround fairGround){
		return ResponseEntity.ok(fairRepo.save(fairGround));
	}
	
	@PutMapping()
	public ResponseEntity<?> updateFairGround(@PathVariable String idFairGround, @RequestBody FairGround event ){
		return null;
	}
	
	@DeleteMapping("/{idFairGround}")
	public ResponseEntity<?> deleteFairGroundById(@PathVariable String idFairGround){
		return null;
	}

}
