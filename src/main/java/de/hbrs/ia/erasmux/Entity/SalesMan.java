package de.hbrs.ia.erasmux.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "salesmen")
public class SalesMan {

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