 insert into Hunter (description, firstName, nick, password, surname) values ('testAdmin', 'AdminFirstName', 'admin', '$2a$10$RE9S3v2J6pkJ9PqNQJcRyukKjdnmxEmjIythEx5GzKTzWs2NuBL76', 'AdminSurname');
 insert into Hunter (description, firstName, nick, password, surname) values ('testUser', 'UserFirstName', 'user', '$2a$10$Tt6vIyNRPQqqFjUCODduD.E4BZe7liy0QIhqqJhkchfxczGB7cqCS', 'UserSurname');
 insert into Hunter (description, firstName, nick, password, surname) values ('testAdminRest', 'AdminFirstNameRest', 'rest', '$2a$10$vGCMsn3yrGt3Z5noJmBs4uSv9c.IfVxI3iq4vIOSqlAdd6h.a6eXC', 'AdminSurnameRest');
 insert into HunterRole (hunter_id, role) values (1,'ROLE_ADMIN');
 insert into HunterRole (hunter_id, role) values (2,'ROLE_USER');
 insert into HunterRole (hunter_id, role) values (3,'ROLE_ADMIN');