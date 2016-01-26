package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.RealestateInsPackage;


public interface RealestatePackRepository extends MongoRepository<RealestateInsPackage, String>{

	public RealestateInsPackage findRealestateInsPackageByName(String name);
}
