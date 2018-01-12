select media0_.productid as producti8_0_0_, media0_.id as id2_0_0_, media0_.id as id2_0_1_, 
media0_.altText as altText3_0_1_, media0_.description as descript4_0_1_, media0_.name as name5_0_1_, 
media0_.productid as producti8_0_1_, media0_.type as type6_0_1_, media0_.length as length7_0_1_, 
media0_.DTYPE as DTYPE1_0_1_ from Media media0_ where media0_.productid=1

select product0_.productid as producti1_2_, product0_.longDescription as longDesc2_2_, 
product0_.name as name3_2_, product0_.price as price4_2_, product0_.searchableTags as searchab5_2_, 
product0_.shortDescription as shortDes6_2_ from Product product0_

select * from Media;
select * from Product;
truncate Product;
truncate Media;