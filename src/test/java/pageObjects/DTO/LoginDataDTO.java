package pageObjects.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginDataDTO {
    private String userName;
    private String password;

    public static LoginDataDTO getDefaultLoginDataDTO() {
        return LoginDataDTO.builder()
                .userName("John123")
                .password("Pass1")
                .build();
    }
}
