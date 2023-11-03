package de.hbrs.ia.erasmux.Repository;

import de.hbrs.ia.erasmux.Entity.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesmanRepository extends MongoRepository<SalesMan, Integer>{


//    SalesMan findByLastname(String lastName);
//    SalesMan findByFirstname(String firstName);
//    SalesMan findByEmail(String email);
    SalesMan findBySid(int sid);
    SalesMan findAllByFirstName(String name);
}
//    private Integer sid;
//    private String firstName = "";
//    private String lastName = "";
//    private String email = "";