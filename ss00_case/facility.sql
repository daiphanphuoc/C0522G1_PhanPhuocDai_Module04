select facility.id, facility.`name`, `description`,leased_area, max_person,  rental_costs, rent_type.`name` as rentType, facility_type.`name` as facilityType  from facility join facility_type on facility_type_id = facility_type.id join rent_type on rent_type_id = rent_type.id where facility.`name` like '%' and facility_type.`name` like '%' and rent_type.`name` like '%' and facility.is_delete = 0  