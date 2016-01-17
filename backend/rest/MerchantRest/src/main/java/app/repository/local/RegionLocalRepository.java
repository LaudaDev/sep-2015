package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Region;



public interface RegionLocalRepository extends MongoRepository<Region,String>{

}
