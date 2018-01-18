truncate category;
truncate product;
truncate media;
insert into category (categoryid, name, parent_categoryid) values (999,'root',null);
insert into category (categoryid, name, parent_categoryid) values (1,'Phones',999);
insert into category (categoryid, name, parent_categoryid) values (101,'Samsung',1);
insert into category (categoryid, name, parent_categoryid) values (102,'iPhones',1);
insert into category (categoryid, name, parent_categoryid) values (103,'LG',1);
insert into category (categoryid, name, parent_categoryid) values (104,'BLACKBERRY',1);
insert into category (categoryid, name, parent_categoryid) values (105,'NOKIA',1);

insert into category (categoryid, name, parent_categoryid) values (911,'rootAChild1',910);
insert into category (categoryid, name, parent_categoryid) values (912,'rootAChild2',910);
insert into category (categoryid, name, parent_categoryid) values (913,'rootAChild3',910);
insert into category (categoryid, name, parent_categoryid) values (9111,'rootAChild1_Child1',911);
insert into category (categoryid, name, parent_categoryid) values (9121,'rootAChild2_Child1',912);
insert into category (categoryid, name, parent_categoryid) values (9131,'rootAChild3_Child1',913);

insert into product ( productid  , name , categoryid) values (1,'S6',101);
insert into media ( DTYPE , id ,name , productid) values ('Image',10, 'S6_MAIN_IMAGE' ,1);
insert into media ( DTYPE , id ,name , productid) values ('Video',11, 'S6_THUMBNAIL_VIDEO' ,1);

insert into product ( productid  , name , categoryid) values (2,'S4',101);
insert into media ( DTYPE , id ,name , productid) values ('Image',20, 'S4_MAIN_IMAGE' ,2);
insert into media ( DTYPE , id ,name , productid) values ('Video',21, 'S4_THUMBNAIL_VIDEO' ,2);

insert into product ( productid  , name , categoryid) values (3,'S3',101);
insert into media ( DTYPE , id ,name , productid) values ('Image',30, 'S3_MAIN_IMAGE' ,3);
insert into media ( DTYPE , id ,name , productid) values ('Video',31, 'S3_THUMBNAIL_VIDEO' ,3);

insert into product ( productid  , name , categoryid) values (4,'iPhone6S',102);
insert into media ( DTYPE , id ,name , productid) values ('Image',40, 'MAIN_IMAGE' ,4);
insert into media ( DTYPE , id ,name , productid) values ('Video',41, 'THUMBNAIL_VIDEO' ,4);

insert into product ( productid  , name , categoryid) values (5,'iPhone-2',102);
insert into media ( DTYPE , id ,name , productid) values ('Image',50, 'MAIN_IMAGE' ,5);
insert into media ( DTYPE , id ,name , productid) values ('Video',51, 'THUMBNAIL_VIDEO' ,5);

insert into product ( productid  , name , categoryid) values (6,'Z3',104);
insert into media ( DTYPE , id ,name , productid) values ('Image',60, 'Z3_MAIN_IMAGE' ,6);
insert into media ( DTYPE , id ,name , productid) values ('Video',61, 'Z3_THUMBNAIL_VIDEO' ,6);

insert into product ( productid  , name , categoryid) values (7,'G6',103);
insert into media ( DTYPE , id ,name , productid) values ('Image',70, 'G6_MAIN_IMAGE' ,7);
insert into media ( DTYPE , id ,name , productid) values ('Video',71, 'G6_THUMBNAIL_VIDEO' ,7);

insert into product ( productid  , name , categoryid) values (8,'LUMIA',105);

insert into media ( DTYPE , id ,name , productid) values ('Image',80, 'LUMIA_MAIN_IMAGE' ,8);
insert into media ( DTYPE , id ,name , productid) values ('Video',81, 'LUMIA_THUMBNAIL_VIDEO' ,8);
select * from category;
select * from product;
select * from media;
