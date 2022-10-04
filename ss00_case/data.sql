
INSERT INTO `position`(`name`,is_delete)
VALUES
('Quản Lý',0),
('Nhân Viên',0);


INSERT INTO education_degree(`name`,is_delete)
VALUES ('Trung Cấp',0),
('Cao Đẳng',0),
('Đại Học',0),
('Sau Đại Học',0);


INSERT INTO division(`name`,is_delete)
VALUES ('Sale-Marketing',0),
('Hành chính',0),
('Phục vụ',0),
('Quản lý',0);


INSERT INTO employee(`name`,birthday,id_citizen,salary,phone,email,address,position_id,degree_id,division_id,is_delete,sex)
VALUES
('Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, P Thanh Bình, Quận Hải Châu, TP Đà Nẵng',1,3,1,0,1),
('Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, P Hải Châu 1, Quận Hải Châu, TP Đà Nẵng',1,2,2,0,1),
('Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2,0,0),
('Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4,0,1),
('Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, P Hải Châu 1, Quận Hải Châu, Đà Nẵng',2,1,1,0,1),
('Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, P Thanh Bình, Quận Hải Châu, Đà Nẵng',2,2,3,0,1),
('Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2,0,1),
('Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4,0,1),
('Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Thạc Gián, Thanh Khê, Đà Nẵng',2,4,4,0,1),
('Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2,0,1);


INSERT INTO customer_type( `name`,is_delete)
VALUES
('Diamond',0),
('Platinium',0),
('Gold',0),
('Silver',0),
('Member',0);


INSERT INTO customer( `name`,birthday,sex,id_citizen,phone,email,address,customer_type_id,is_delete)
VALUES 
('Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng,P Hải Châu 2, Quận Hải Châu, TP Đà Nẵng',5,0),
('Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3,0),
('Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1,0),
('Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, P Thạch Thang, Quận Hải Châu, TP Đà Nẵng',1,0),
('Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4,0),
('Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, P Hòa An, Quận Cẩm Lệ, TP Đà Nẵng',4,0),
('Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','123/45 Lê Lợi,Phường Bến Nghé, Quận 1, TP Hồ Chí Minh',1,0),
('Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3,0),
('Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Phường Nghĩa Chánh Nam, TP Quảng Ngãi',1,0),
('Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Quận Sơn Trà, TP Đà Nẵng',2,0),
('Phạm Đạt','1993-07-01',1,'212368165','0988888888','datpham@gmail.com','999 Nguyễn Tất Thành, Quận hải Châu, TP Đà Nẵng',2,0);


INSERT INTO facility_type(`name`,is_delete)
VALUES
('Villa',0),
('House',0),
('Room',0);


INSERT INTO rent_type(`name`,is_delete)
VALUES 
('year',0),
('month',0),
('day',0),
('hour',0);

INSERT INTO facility(`name`,leased_area,rental_costs,max_person,room,`description`,area_pool,floor,free,rent_type_id,facility_type_id,is_delete,dtype)
VALUES 
('Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,0,3,1,0,'villa'),
('House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',0,3,0,2,2,0,'house'),
('Room Twin 01',5000,1000000,2,'normal','Có tivi',0,0,'1 Xe máy, 1 Xe đạp',4,3,0,'room'),
('Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,0,3,1,0,'villa'),
('House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',0,2,0,3,2,0,'house'),
('Room Twin 02',3000,900000,2,'normal','Có tivi',0,0,'1 Xe máy',4,3,0,'room'),
('House Princess 03',10000,4000000,5,'normal','Có thêm bếp nướng',0,2,0,3,2,0,'house');


INSERT INTO contract(start,end,deposit,employee_id,customer_id,facility_id,is_delete,total_money)
VALUES
('2020-12-08','2020-12-08',0,3,1,3,0,0),
('2020-07-14','2020-07-21',200000,7,3,1,0,0),
('2021-03-15','2021-03-17',50000,3,4,2,0,0),
('2021-01-14','2021-01-18',100000,7,5,5,0,0),
('2021-07-14','2021-07-15',0,7,2,6,0,0),
('2021-06-01','2021-06-03',0,7,7,6,0,0),
('2021-09-02','2021-09-05',100000,7,4,4,0,0),
('2021-06-17','2021-06-18',150000,3,4,1,0,0),
('2020-11-19','2020-11-19',0,3,4,3,0,0),
('2021-04-12','2021-04-14',0,10,3,5,0,0),
('2021-04-25','2021-04-25',0,2,2,1,0,0),
('2021-05-25','2021-05-27',0,7,10,1,0,0);

INSERT INTO attach_facility(`name`,cost,unit,`status`,is_delete)
VALUES 
('Karaoke',10000,'giờ','tiện nghi hiện tại',0),
('Thuê xe máy',10000,'chiếc','hỏng 1 xe',0),
('Thuê xe đạp',20000,'chiếc','tốt',0),
('Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng',0),
('Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng',0),
('Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng',0);

INSERT INTO contract_detail(quantity,contract_id,attach_facility_id,is_delete)
VALUES 
(5,2,4,0),
(8,2,5,0),
(15,2,6,0),
(1,3,1,0),
(11,3,2,0),
(1,1,3,0),
(2,1,2,0),
(2,12,2,0);






