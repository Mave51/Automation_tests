package pageObjects.DTO;

import lombok.Builder;
import lombok.Getter;
import pageObjects.BasePage;

@Builder
@Getter
public class AccountRegistrationDTO {
    private String name;
    private String surname;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;
    private String ssnNumber;
    private String userName;
    private String password;

    public static AccountRegistrationDTO getDefaultDTO() {
        return AccountRegistrationDTO.builder()
                .name("John")
                .surname("Johnson")
                .street("5th Avenue")
                .city("NewYork")
                .state("New York")
                .zipcode("00-00")
                .phoneNumber("180080000")
                .ssnNumber("0000")
                .userName(BasePage.createRandomUserName(5))
                .password("pass1")
                .build();
    }
}
