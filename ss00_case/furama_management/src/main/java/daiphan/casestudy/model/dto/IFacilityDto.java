package daiphan.casestudy.model.dto;

import daiphan.casestudy.model.facility.FacilityType;
import daiphan.casestudy.model.facility.RentType;

public interface IFacilityDto {

    int getId();

    String getName();

    double getLeasedArea();

    double getRentalCosts();

    int getMaxPerson();

    RentType getRentType();

    FacilityType getFacilityType();

    String getDescription();

    String getRoom();

    int getFloor();

    double getAreaPool();

    String getFree();
}
