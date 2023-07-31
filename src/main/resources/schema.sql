DROP SCHEMA IF EXISTS stc;
CREATE SCHEMA stc;

create table if not EXISTS app_role (
id bigint not null,
 name varchar(255),
 primary key (id));
create table if not EXISTS item (
   id bigint not null,
   name varchar(255),
   type varchar(255),
   location_id bigint,
   primary key (id),
   FOREIGN KEY (location_id)
       REFERENCES item (id));

create table if not EXISTS files (
id bigint not null,
 file_binary bytea,
 file_name varchar(255),
 test varchar(255),
 location_id bigint,
 primary key (id),
 FOREIGN KEY (location_id)
 REFERENCES item (id));

create table if not EXISTS service_user
(id bigint not null,
 password varchar(255),
 user_email varchar(255),
 primary key (id));

create table if not EXISTS itemwuser_permission (
id bigint not null,
 operation varchar(255),
 item_id bigint,
 user_id bigint,
 primary key (id),
 FOREIGN KEY (item_id)
 REFERENCES item (id),
 FOREIGN KEY (user_id)
 REFERENCES service_user (id)
 );



create table if not EXISTS service_user_roles (
service_user_id bigint not null,
 roles_id bigint not null,
FOREIGN KEY (roles_id)
 REFERENCES app_role (id),
FOREIGN KEY (service_user_id)
 REFERENCES service_user (id));
