package daiphan.casestudy.dto.person;

import daiphan.casestudy.model.facility.FacilityType;
import daiphan.casestudy.model.facility.RentType;

public interface IFacilityDto {

    int getId();

    String getName();

    double getLeasedArea();

    double getRentalCosts();

    int getMaxPerson();

    String getRentType();

    String getFacilityType();

    String getDescription();
}
