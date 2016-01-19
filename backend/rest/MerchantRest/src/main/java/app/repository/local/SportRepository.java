package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Sport;


public interface SportRepository extends MongoRepository<Sport,String> {

}
