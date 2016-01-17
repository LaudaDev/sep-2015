package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.RealestateInsPackage;


public interface RealestatePackLocalRepository extends MongoRepository<RealestateInsPackage, String>{

}
