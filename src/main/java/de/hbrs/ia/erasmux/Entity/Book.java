package de.hbrs.ia.erasmux.Entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Data
@Document(collection = "salesmen")
public class Books {

    @Id
    private Integer sid;
    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";
    @NotEmpty
    private String email = "";

}