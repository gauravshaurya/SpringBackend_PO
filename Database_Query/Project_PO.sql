create SEQUENCE id_sequence
  INCREMENT BY 1 MAXVALUE 5000 CYCLE;

create table tbl_role(
        roleId number(5) primary key not null,
        roleName varchar(20) not null
)

create table tbl_product(
        product_id number(5) primary key not null,
        product_name varchar(100) not null,
        product_price number(10) not null
)

create table tbl_vp(
        vp_id number(10) primary key,
        product_id number(5) not null,
        product_name varchar(100) not null,
        product_price number(10) not null,
        quantity number(10) not null,
        vendorId number(10)
)

create sequence product_id start with 1001 increment by 1;
insert into tbl_product values(product_id.nextval,'Realme X2 Pro',30000);
insert into tbl_product values(product_id.nextval,'MI Mix 3',35000);
insert into tbl_product values(product_id.nextval,'Redmi Note 8 Pro',16000);
insert into tbl_product values(product_id.nextval,'Redmi K20 Pro',33000);
insert into tbl_product values(product_id.nextval,'Canon EOS 1300D',30000);
insert into tbl_product values(product_id.nextval,'Canon EOS 1700D',60000);
insert into tbl_product values(product_id.nextval,'Canon EOS 1500D',45000);
insert into tbl_product values(product_id.nextval,'Nikon D3500',35000);
insert into tbl_product values(product_id.nextval,'Nikon D7200',50000);
insert into tbl_product values(product_id.nextval,'Boosted Electric SkateBoard',80000);
insert into tbl_product values(product_id.nextval,'M1 Electric SkateBoard',70000);
insert into tbl_product values(product_id.nextval,'Mi Electric Scooter Pro',85000);
insert into tbl_product values(product_id.nextval,'MacBook Pro 15',190000);
insert into tbl_product values(product_id.nextval,'Surface Book 2',150000);
insert into tbl_product values(product_id.nextval,'Alienware M15 r2',160000);
insert into tbl_product values(product_id.nextval,'Kindle PaperWhite',12000);
insert into tbl_product values(product_id.nextval,'DJI Mavic Pro',110000);
insert into tbl_product values(product_id.nextval,'Sony wh-1000xm3',27000);
insert into tbl_product values(product_id.nextval,'Bose QuiteComfort 35 II',29000);
insert into tbl_product values(product_id.nextval,'Bose Headphone 700',35000);

commit

desc tbl_product

select * from tbl_product

drop table tbl_Product


create table tbl_user(
        userId number(5) primary key,
        userName VARCHAR2(20) not null,
        phone number(10) not null,
        email varchar(50) not null,
        houseNo number(5) not null,
        address1 VARCHAR2(20) not null,
        address2 number(20) not null,
        city varchar(50) not null,
        state varchar2(20) not null,
        userPass varchar2(20) not null,
        roleId not null,
        is_active char(1),
        created_By varchar(10),
        created_date date,
        updated_by varchar2(20),
        updated_date date,
        foreign key (roleId) references tbl_role(roleId)
)
 
create table tbl_address(
        houseNo number(5) primary key,
        address1 VARCHAR2(20) not null,
        address2 number(20) not null,
        city varchar(50) not null,
        state varchar2(20) not null
)
 
INSERT INTO tbl_role
VALUES (3,'Vendor')

select * from tbl_user

INSERT INTO tbl_user
VALUES (501,'Block C','Sector-P3','Greater Noida',95,201308,'Uttar Pradesh',
'System',sysdate,'g@gmail.com','Y','g123',9650187167,'Seller',Null,Null,'Gourav Kumar')

delete from tbl_user where userid=503

INSERT INTO tbl_user
VALUES (503,'Block C','Dwarka','New Delhi',95,110056,'Delhi',
'System',sysdate,'h@gmail.com','Y','h123',9650187167,'Buyer',Null,Null,'Himanshu Malik')

commit

select * from tbl_role

select * from TBL_VP

drop table TBL_VP

drop table tbl_role
commit

drop table tbl_user
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = "tbl_user"


select * from tbl_product

drop table tbl_product;

select * from tbl_user

delete from tbl_user where userId=91

desc tbl_user

select * from tbl_address
 
drop table tbl_user

drop table tbl_role;

select * from tbl_user

  select * from PurchaseOrderItems
  
  Select * from tbl_user;
  
delete from PurchaseOrderItems
delete from PurchaseOrderTab

select * from PurchaseOrderItems
select * from PurchaseOrderTab

  commit
  
