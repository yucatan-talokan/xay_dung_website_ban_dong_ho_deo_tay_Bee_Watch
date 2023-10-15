CREATE DATABASE website_selling_Bee_Watches
go
USE website_selling_Bee_Watches

--voucher

create table VouchersType (
    id UNIQUEIDENTIFIER  NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    description NVARCHAR(MAX) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

INSERT VouchersType(code ,name ,description ,created_by ,updated_by ,created_date , update_date, is_deleted)
VALUES('VCH01',N'giờ vàng',N'giảm giá 10% cho đơn hàng từ 20k','rok','rok','2023-01-23','2023-01-25',1),
('VCH02',N'giờ vàng',N'giảm giá 20% cho đơn hàng từ 100k','rok','rok','2023-01-23','2023-01-25',1),
('VCH03',N'giờ vàng',N'giảm giá 30% cho đơn hàng từ 200k','rok','rok','2023-01-23','2023-01-25',0),
('VCH04',N'giờ vàng',N'giảm giá 40% cho đơn hàng từ 500k','rok','rok','2023-01-23','2023-01-25',0),
('VCH05',N'giờ vàng',N'giảm giá 50% cho đơn hàng từ 1M','rok','rok','2023-01-23','2023-01-25',0)

create table Vouchers (
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    voucher_type_id UNIQUEIDENTIFIER null ,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    sale_price FLOAT null, -- giảm theo giá 
    sale_percent VARCHAR(10) null, -- giảm theo %
    min_price FLOAT null,
    description NVARCHAR(MAX) null,
    start_date DATE null,
    end_date DATE null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

-- insert Vouchers(code ,name ,sale_price ,sale_percent ,min_price ,description ,start_date ,end_date ,created_by ,updated_by ,created_date , update_date, is_deleted)
-- VALUES('VCH01',N'giảm giá giờ vàng',20000 ,'15%' ,N'giảm giá 15% cho đơn hàng từ 20k','rok','rok','2023-01-23','2023-01-25',1),

-- acount

CREATE table Addresss(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    province_code nvarchar(20) null, -- mã tỉnh
    district_code NVARCHAR(30) null, --mã quận
    commune_code NVARCHAR(30) null, --mã xã
    address_detail NVARCHAR(MAX) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go


INSERT Addresss(province_code ,district_code ,commune_code ,address_detail , created_date ,update_date , is_deleted)
VALUES('ND-18','GT','GX',N'Giao Xuân, Giao Thủy, Nam Định','2023-10-15','2023-10-15',0),
('ND-18','GT','GX',N'Giao Xuân, Giao Thủy, Nam Định','2023-10-15','2023-10-15',0),
('ND-18','GT','GX',N'Giao Xuân, Giao Thủy, Nam Định','2023-10-15','2023-10-15',0),
('ND-18','GT','GX',N'Giao Xuân, Giao Thủy, Nam Định','2023-10-15','2023-10-15',0),
('ND-18','GT','GX',N'Giao Xuân, Giao Thủy, Nam Định','2023-10-15','2023-10-15',0)


CREATE TABLE Payment_Method(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    name NVARCHAR(30) null,
)
go

CREATE TABLE Roles(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    role_name nvarchar(20) null, -- mã giá 
)
go

CREATE TABLE Account_Roles(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    id_account UNIQUEIDENTIFIER null,
    id_role UNIQUEIDENTIFIER null,

)
go

Drop TABLE Account_Roles

CREATE Table Accounts(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    address_id UNIQUEIDENTIFIER null,
    role_id UNIQUEIDENTIFIER null,
    username NVARCHAR(30) null,
    password NVARCHAR(30) null,
    fullname NVARCHAR(30) null,
    gender NVARCHAR(30) null,
    date_of_birth DATE null,
    email NVARCHAR(30) null,
    phone NVARCHAR(30) null,
    avatar NVARCHAR(MAX) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Orders(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    id_account UNIQUEIDENTIFIER null,
    id_voucher UNIQUEIDENTIFIER null,
    id_payment_method_id uniqueidentifier null,
    code NVARCHAR(30) null,
    total_money money null,
    total_payment money null,
    date_payment DATE null,
    shipping_price money null,
    shipping_date DATE null,
    received_date DATE null,
    create_date DATE null,
    update_date DATE null,
    status BIT null,
    is_deleted BIT null,
)
go


CREATE TABLE OrderDetails(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    id_order UNIQUEIDENTIFIER null,
    id_watch_detail UNIQUEIDENTIFIER null,
    quantity BIGINT null,
    total_price money null,
    is_deleted BIT null,
)
go



-- promo Product type

CREATE TABLE PromoTypes (
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(30) null,
    name NVARCHAR(30) null,
    description NVARCHAR(MAX) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Promos(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    promo_type_id  UNIQUEIDENTIFIER ,
    code NVARCHAR(30) null,
    name NVARCHAR(30) null,
    start_date DATE null,
    end_date DATE null,
    description NVARCHAR(MAX) null,
    sale_percent VARCHAR(10) null, -- giảm theo %
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

-- product 

CREATE TABLE WatchDetail(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    id_brand UNIQUEIDENTIFIER null,
    id_series UNIQUEIDENTIFIER null,
    id_machine_line UNIQUEIDENTIFIER null ,-- dongf máy 
    id_gender UNIQUEIDENTIFIER null ,--gioi tinh
    id_strap UNIQUEIDENTIFIER null ,--dây đeo
    id_glass_material UNIQUEIDENTIFIER null ,--chất lệu kính 
    id_feature UNIQUEIDENTIFIER null,--tính năng
    id_glass_size UNIQUEIDENTIFIER null ,--kích thức mặt kính
    id_origin UNIQUEIDENTIFIER null ,--xuat xu
    id_shell_material UNIQUEIDENTIFIER null ,-- chất liệu vỏ
    id_shape UNIQUEIDENTIFIER null ,-- hình dạng
    id_glass_model UNIQUEIDENTIFIER null ,-- mẫu mặt kính 
    price FLOAT null,
    quantity_stock BIGINT null,-- số lượng tồn
    description NVARCHAR(MAX) null,
    status BIT null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go



CREATE TABLE Images(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    id_watch_detail UNIQUEIDENTIFIER null,
    image_link NVARCHAR(MAX) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Brands(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go 

CREATE TABLE Series(
    id UNIQUEIDENTIFIER  NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE MachineLine(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Gender(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Strap(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Glass_Material(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Feature(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Glass_Size(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go


CREATE TABLE Origin(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Shell_Material(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go


CREATE TABLE Shape(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Glass_Model(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null, 
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

create TABLE Favorite_Product(
    id UNIQUEIDENTIFIER NOT NULL DEFAULT newid() PRIMARY KEY,
    created_date DATE null,
    update_date DATE null,
)
go

ALTER TABLE Vouchers ADD FOREIGN KEY(voucher_type_id) REFERENCES VouchersType(id) --1

ALTER TABLE Promos ADD FOREIGN KEY(promo_type_id) REFERENCES PromoTypes(id) --1

ALTER TABLE WatchDetail ADD FOREIGN KEY(id_brand) REFERENCES Brands(id) --1
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_series) REFERENCES Series(id) --2
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_machine_line) REFERENCES MachineLine(id) --3
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_gender) REFERENCES Gender(id) --4
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_strap) REFERENCES Strap(id) --5
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_glass_material) REFERENCES Glass_Material(id) --6
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_feature) REFERENCES Feature(id) --7
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_glass_size) REFERENCES Glass_Size(id) --8
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_origin) REFERENCES origin(id) --9
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_shell_material) REFERENCES shell_material(id) --10
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_shape) REFERENCES shape(id) --11
ALTER TABLE WatchDetail ADD FOREIGN KEY(id_glass_model) REFERENCES glass_model(id) --12

ALTER TABLE Images ADD FOREIGN KEY(id_watch_detail) REFERENCES WatchDetail(id) 

ALTER TABLE OrderDetails ADD FOREIGN KEY(id_order) REFERENCES Orders(id)
ALTER TABLE OrderDetails ADD FOREIGN KEY(id_watch_detail) REFERENCES WatchDetail(id) 

ALTER TABLE Orders ADD FOREIGN KEY(id_account) REFERENCES Accounts(id) 
ALTER TABLE Orders ADD FOREIGN KEY(id_voucher) REFERENCES Vouchers(id) 
ALTER TABLE Orders ADD FOREIGN KEY(id_payment_method_id) REFERENCES Payment_Method(id) 

ALTER TABLE Accounts ADD FOREIGN KEY(role_id) REFERENCES Roles(id) 
ALTER TABLE Accounts ADD FOREIGN KEY(address_id) REFERENCES Addresss(id) 

DROP Database website_selling_Bee_Watches