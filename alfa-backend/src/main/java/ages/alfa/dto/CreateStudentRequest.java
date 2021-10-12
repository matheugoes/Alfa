package ages.alfa.dto;

import ages.alfa.model.enumeration.Gender;
import ages.alfa.model.enumeration.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest implements Serializable {

    public final static long serialVersionUID = -3485641921902101827L;

    private String firstLine;

    private String secondLine;

    private String city;

    private String country;

    private String name;

    private Gender gender;

    private Race race;

    private String email;
}
