package daiphan.casestudy.model.facility;

import daiphan.casestudy.model.business.Contract;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class House extends Facility {
    private String room;
    private int floor;

    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

    public House() {
    }

    @Override
    public String getInfo() {
        return String.format("%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s",
                getFacilityType().getName(),getIDFacility(), getName(),getLeasedArea(),
                getRentalCosts(),getMaxPerson(), getRentType().getName(),
                getDescription(),getRoom(),getFloor(),"null","null");
    }

    public House(int iDFacility, String nameFacility, double leasedArea, double rentalCosts,
                 int maxPerson, RentType rentalType,FacilityType facilityType, String description,
                 String room, int floor) {
        super(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson,
                rentalType,facilityType, description);
        this.room = room;
        this.floor = floor;
    }

    public House(String nameFacility, double leasedArea, double rentalCosts, int maxPerson, RentType rentalType, FacilityType facilityType, String description, String room, int floor) {
        super(nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, facilityType, description);
        this.room = room;
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return getIDFacility()==house.getIDFacility();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDFacility());
    }
}
