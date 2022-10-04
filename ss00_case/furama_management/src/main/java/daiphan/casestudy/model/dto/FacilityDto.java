package daiphan.casestudy.model.dto;

import daiphan.casestudy.model.facility.FacilityType;
import daiphan.casestudy.model.facility.RentType;



public class FacilityDto {
    private int id;
    private String name;
    private double leasedArea;
    private double rentalCosts;
    private int maxPerson;
    private boolean isDelete;
    private RentType rentType;
    private FacilityType facilityType;
    private String description;
    private String room;
    private int floor;
    private double areaPool;
    private String free;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, double leasedArea, double rentalCosts, int maxPerson, boolean isDelete, RentType rentType, FacilityType facilityType, String description, String room, int floor, double areaPool, String free) {
        this.id = id;
        this.name = name;
        this.leasedArea = leasedArea;
        this.rentalCosts = rentalCosts;
        this.maxPerson = maxPerson;
        this.isDelete = isDelete;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.description = description;
        this.room = room;
        this.floor = floor;
        this.areaPool = areaPool;
        this.free = free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLeasedArea() {
        return leasedArea;
    }

    public void setLeasedArea(double leasedArea) {
        this.leasedArea = leasedArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }
}
