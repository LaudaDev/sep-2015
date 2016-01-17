package app.repository.local;
import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.User;


public interface UserLocalRepository extends MongoRepository<User, String>{
}
