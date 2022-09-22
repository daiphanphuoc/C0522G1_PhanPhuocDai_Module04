package daiphan.casestudy.model.facility;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "facility")
public class Room extends Facility{
    String free;

    public Room() {
    }

    public Room(String nameFacility, double leasedArea, double rentalCosts, int maxPerson, RentType rentalType, FacilityType facilityType, String description, String free) {
        super(nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, facilityType, description);
        this.free = free;
    }

    @Override
    public String getInfo() {
        return String.format("%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s",getFacilityType().getName(),getIDFacility(), getName(),getLeasedArea(),
                getRentalCosts(),getMaxPerson(), getRentType().getName(),
                getDescription(),"null","null","null",getFree());
    }

    public Room(int iDFacility, String nameFacility, double leasedArea, double rentalCosts,
                int maxPerson, RentType rentalType,FacilityType facilityType, String descriptionOtherConvenience,
                String free) {
        super(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType,facilityType,
                descriptionOtherConvenience);
        this.free = free;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Room{ " + super.toString() +
                "free='" + free + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(getIDFacility(), room.getIDFacility());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDFacility());
    }
}
