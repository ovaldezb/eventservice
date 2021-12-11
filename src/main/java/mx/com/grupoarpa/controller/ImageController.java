package mx.com.grupoarpa.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import mx.com.grupoarpa.entity.Image;
import mx.com.grupoarpa.repository.ImageRepository;
import mx.com.grupoarpa.utils.Utils;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@RestController
@RequestMapping("/v1/api/images")
@EnableSwagger2
@CrossOrigin(origins = "*")
public class ImageController {

	@Autowired
	ImageRepository imageRepo;

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("title") String title,
			@RequestParam("image") MultipartFile image) {
		try {
			Image imageSave = new Image();
			imageSave.setName(title);
			imageSave.setImage(Utils.compressBytes(image.getBytes()));
			return ResponseEntity.ok(imageRepo.save(imageSave));
		} catch (IOException ioex) {
			log.error("Error al cargarla foto", ioex);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{imageId}")
	public ResponseEntity<?> getImage(@PathVariable final String imageId) {

		Optional<Image> imageFound = imageRepo.findById(imageId);
		if (imageFound.isPresent()) {
			Image imageReturn = new Image();
			imageReturn.setId(imageFound.get().getId());
			imageReturn.setName(imageFound.get().getName());
			imageReturn.setImage(Utils.decompressBytes(imageFound.get().getImage()));
			return ResponseEntity.ok(imageReturn);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
