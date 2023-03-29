package co.com.umb.crowdfunding.arquitectura.infrastructure.driveradapter.customerpostgresql.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ERol {

    ADMIN(1,"admin"),
    COMPRADOR(2,"COMPRADOR"),
    VENDEDOR(3, "vendedor");

    private int id;
    private String rol;
}
