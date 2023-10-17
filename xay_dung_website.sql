drop database website_selling_Bee_Watches

CREATE DATABASE website_selling_Bee_Watches
go
USE website_selling_Bee_Watches

--voucher

CREATE TABLE Products(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go 

CREATE TABLE Brands(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go 

CREATE TABLE Serials(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE MachineTypes(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Genders(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Straps(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE GlassMaterials(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Features(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go



CREATE TABLE Origins(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE CaseMaterials(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE CaseColors(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go


CREATE TABLE Shapes(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Sizes(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE WatchDetails(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    id_brand UNIQUEIDENTIFIER null,
    id_serial UNIQUEIDENTIFIER null,
    id_machine_type UNIQUEIDENTIFIER null ,-- dongf máy 
    id_gender UNIQUEIDENTIFIER null ,--gioi tinh
    id_strap UNIQUEIDENTIFIER null ,--dây đeo
    id_glass_material UNIQUEIDENTIFIER null ,--chất lệu kính 
    id_feature UNIQUEIDENTIFIER null,--tính năng
    id_size UNIQUEIDENTIFIER null ,--kích thức mặt kính
    id_origin UNIQUEIDENTIFIER null ,--xuat xu
    id_case_material UNIQUEIDENTIFIER null ,-- chất liệu vỏ
	id_case_color UNIQUEIDENTIFIER null ,
    id_shape UNIQUEIDENTIFIER null ,-- hình dạng
	id_product UNIQUEIDENTIFIER,
    price decimal null,
    quantity_stock BIGINT null,-- số lượng tồn
    description NVARCHAR(MAX) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
	status BIT null,
    is_deleted BIT null,
	foreign key(id_brand) references brands (id),
	foreign key(id_serial) references serials (id),
	foreign key(id_machine_type) references machinetypes (id),
	foreign key(id_gender) references genders (id),
	foreign key(id_strap) references straps (id),
	foreign key(id_glass_material) references glassmaterials (id),
	foreign key(id_feature) references features (id),
	foreign key(id_size) references sizes (id),
	foreign key(id_origin) references origins (id),
	foreign key(id_case_material) references casematerials (id),
	foreign key(id_shape) references shapes (id),
	foreign key(id_product) references products (id),
	foreign key(id_case_color) references casecolors (id),
)
go

CREATE TABLE Images(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    id_watch_detail UNIQUEIDENTIFIER null,
    image_link NVARCHAR(MAX) null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
	foreign key (id_watch_detail) references watchdetails(id)
)
go

create table VoucherTypes (
    id UNIQUEIDENTIFIER PRIMARY KEY,
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

create table Vouchers (
    id UNIQUEIDENTIFIER PRIMARY KEY,
    id_voucher_type UNIQUEIDENTIFIER null,
    code NVARCHAR(20) null,
    name NVARCHAR(30) null,
    sale_price decimal null, -- giảm theo giá 
    sale_percent Integer null, -- giảm theo %
    min_price decimal null,
    description NVARCHAR(MAX) null,
    start_date DATE null,
    end_date DATE null,
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
	foreign key(id_voucher_type) references vouchertypes(id)
)
go

CREATE TABLE PromoTypes (
    id UNIQUEIDENTIFIER PRIMARY KEY,
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
    id UNIQUEIDENTIFIER PRIMARY KEY,
    id_promo_type  UNIQUEIDENTIFIER,
    code NVARCHAR(30) null,
    name NVARCHAR(30) null,
    start_date DATE null,
    end_date DATE null,
    description NVARCHAR(MAX) null,
    sale_percent Integer null, -- giảm theo %
    created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
	foreign key(id_promo_type) references promotypes(id)
)
go

-- acount

CREATE table Address(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    province_code nvarchar(20) null, -- mã giá 
    district_code NVARCHAR(30) null, --mã quận
    town_code NVARCHAR(30) null, --mã xã
    address_detail NVARCHAR(MAX) null,
	created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
)
go

CREATE TABLE Roles(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    name nvarchar(20) null, -- mã giá 
)
go

CREATE Table Accounts(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    id_address UNIQUEIDENTIFIER null,
    username NVARCHAR(30) null,
    password char(80) null,
    fullname NVARCHAR(30) null,
    gender bit null,
    date_of_birth DATE null,
    email NVARCHAR(30) null,
    phone NVARCHAR(30) null,
    avatar NVARCHAR(MAX) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
	foreign key (id_address) references address(id)
)
go

CREATE TABLE AccountRoles(
    id_account UNIQUEIDENTIFIER,
	id_role UNIQUEIDENTIFIER,
    primary key(id_account,id_role),
	foreign key(id_account) references accounts (id),
	foreign key(id_role) references roles (id),
)
go

CREATE TABLE PaymentMethods(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    name NVARCHAR(30) null,
	created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
)
go

CREATE TABLE Orders(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    id_account UNIQUEIDENTIFIER null,
    
    id_payment_method uniqueidentifier null,
    code NVARCHAR(30) null,
    total_money decimal null,
    total_payment decimal null,
    date_payment DATE null,
    shipping_price decimal null,
    shipping_date DATE null,
    received_date DATE null,
	created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    create_date DATE null,
    update_date DATE null,
    status BIT null,
    is_deleted BIT null,
	foreign key(id_account) references accounts(id),
	foreign key(id_payment_method) references paymentmethods(id),
)
go


CREATE TABLE OrderDetails(
    id UNIQUEIDENTIFIER PRIMARY KEY,
    id_order UNIQUEIDENTIFIER null,
    id_watch_detail UNIQUEIDENTIFIER null,
    quantity BIGINT null,
    total_price decimal null,
	created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
    is_deleted BIT null,
	foreign key(id_order) references orders(id),
	foreign key(id_watch_detail) references watchdetails(id),
)
go

create TABLE Favourites(
    id UNIQUEIDENTIFIER PRIMARY KEY,
	created_by NVARCHAR(25) null,
    updated_by NVARCHAR(25) null,
    created_date DATE null,
    update_date DATE null,
)
go




