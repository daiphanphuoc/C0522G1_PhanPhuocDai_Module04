package daiphan.casestudy.dto.person;

import java.util.Date;

public interface IEmployeeDto {
    int getId();
    String getName();
    Date getBirthday();
    String getPosition();
    String getAddress();
    boolean isSex();
    String getIdCitizen();
}
