package forkjoin.glucosemonitor.dto;

import forkjoin.glucosemonitor.entity.Diary;
import forkjoin.glucosemonitor.entity.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    @NotEmpty
    @NotNull
    @Size(min = 5, message = "Username should have at least 5 characters")
    private String username;

    @NotEmpty
    @NotNull
    @Size(min = 5, message = "Password should have at least 5 characters")
    private String password;

    private Set<DiaryDto> diaries;

    private Role role;

}
