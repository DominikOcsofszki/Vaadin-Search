package de.hbrs.ia.erasmux.Entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class SalesMen {

    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";
    @NotEmpty
    private String email = "";

}