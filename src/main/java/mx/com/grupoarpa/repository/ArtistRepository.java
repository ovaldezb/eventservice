package mx.com.grupoarpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.com.grupoarpa.entity.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String> {

}
