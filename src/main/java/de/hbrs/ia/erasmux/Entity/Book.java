package de.hbrs.ia.erasmux.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Data
//@Document(collection = "books")
public class Book {

    @Id
    @GeneratedValue
    private Integer sid;
    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";
    @NotEmpty
    private String email = "";

}