package mx.com.grupoarpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.com.grupoarpa.entity.Event;

public interface EventRepository extends MongoRepository<Event, String> {

}
