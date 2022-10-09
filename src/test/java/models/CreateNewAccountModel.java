package models;

import lombok.Builder;
import lombok.Data;

import java.util.PrimitiveIterator;

@Data
@Builder

public class CreateNewAccountModel {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String confirmPassword;
}
