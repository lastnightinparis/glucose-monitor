package forkjoin.glucosemonitor.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SignUpRequest implements Serializable {
    @NotEmpty
    @NotNull
    @Size(min = 5, message = "Username should have at least 5 characters")
    private String username;

    @NotEmpty
    @NotNull
    @Size(min = 5, message = "Password should have at least 5 characters")
    private String password;
}
