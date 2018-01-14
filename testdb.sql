truncate category;
insert into category (categoryid, name, parent_categoryid) values (910,'rootA',null);
insert into category (categoryid, name, parent_categoryid) values (911,'rootAChild1',910);
insert into category (categoryid, name, parent_categoryid) values (912,'rootAChild2',910);
insert into category (categoryid, name, parent_categoryid) values (913,'rootAChild3',910);
insert into category (categoryid, name, parent_categoryid) values (9111,'rootAChild1_Child1',911);
insert into category (categoryid, name, parent_categoryid) values (9121,'rootAChild2_Child1',912);
insert into category (categoryid, name, parent_categoryid) values (9131,'rootAChild3_Child1',913);
select * from category;

