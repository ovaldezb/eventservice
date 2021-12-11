package mx.com.grupoarpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.com.grupoarpa.entity.Image;

public interface ImageRepository extends MongoRepository<Image, String> {

}
