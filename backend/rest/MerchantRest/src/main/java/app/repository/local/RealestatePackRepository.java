package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.RealestateInsPackage;


public interface RealestatePackRepository extends MongoRepository<RealestateInsPackage, String>{

}
