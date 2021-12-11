package mx.com.grupoarpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.com.grupoarpa.entity.FairGround;

public interface FairgroundRepository extends MongoRepository<FairGround, String> {

}
