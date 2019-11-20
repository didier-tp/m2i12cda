create table Devise(code varchar(12) not null primary key,
                   nom varchar(128) not null,
                   dchange double);
                   
insert into devise(code,nom,dchange) values('EUR','euro',0.9);
insert into devise(code,nom,dchange) values('USD','dollar',1);
insert into devise(code,nom,dchange) values('JPY','yen',125);
insert into devise(code,nom,dchange) values('GBP','livre',0.8);

select * from devise;