package mx.com.grupoarpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.com.grupoarpa.entity.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
