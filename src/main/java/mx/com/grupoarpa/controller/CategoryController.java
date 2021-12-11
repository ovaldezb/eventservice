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

import mx.com.grupoarpa.entity.Category;
import mx.com.grupoarpa.repository.CategoryRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/v1/api/categories")
@EnableSwagger2
@CrossOrigin(origins = "*")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepo;
	
	@PostMapping
	public ResponseEntity<?> addCategory(@RequestBody final Category category){
		return ResponseEntity.ok(categoryRepo.save(category));
	}
	
	@GetMapping
	public ResponseEntity<?> getCategories(){
		List<Category> listCategories = categoryRepo.findAll();
		if(!listCategories.isEmpty()) {
			return ResponseEntity.ok(listCategories);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/{idCategory}")
	public ResponseEntity<?> getCategoryById(@PathVariable final String idCategory){
		Optional<Category> categoryFound = categoryRepo.findById(idCategory);
		if(categoryFound.isPresent()) {
			return ResponseEntity.ok(categoryFound.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{idCategory}")
	public ResponseEntity<?> updateCategory(@PathVariable final String idCategory, @RequestBody Category categorySave){
		Optional<Category> categoryFound = categoryRepo.findById(idCategory);
		if(categoryFound.isPresent()) {
			Category categoryUpdate = categoryFound.get();
			categoryUpdate.setCategoryName(categorySave.getCategoryName());
			return ResponseEntity.ok(categoryRepo.save(categoryUpdate));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{idCategory}")
	public ResponseEntity<?> deleteCategory(@PathVariable String idCategory){
		Optional<Category> categoryDelete = categoryRepo.findById(idCategory);
		if(categoryDelete.isPresent()) {
			categoryRepo.deleteById(idCategory);
			return ResponseEntity.ok().body("OK");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
