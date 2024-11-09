package pages.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TextBoxPojo {

    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

}
