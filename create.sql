create table appointments (id integer not null auto_increment, canceled bit, owners_comment varchar(255), available_time_id integer not null, pet_id integer not null, service_id integer not null, primary key (id)) engine=InnoDB;
create table available_times (id integer not null auto_increment, booked bit, date datetime not null, veterinarian_id integer not null, primary key (id)) engine=InnoDB;
create table clients (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table conditions (id integer not null auto_increment, condition_name varchar(255) not null, note varchar(255), pet_record_id integer not null, primary key (id)) engine=InnoDB;
create table owned_pets (id integer not null auto_increment, pet_owner_id varchar(255) not null, pet_id integer, primary key (id)) engine=InnoDB;
create table pet_owners (id varchar(255) not null, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table pet_records (id integer not null auto_increment, pet_id integer not null, primary key (id)) engine=InnoDB;
create table pets (id integer not null auto_increment, birthday datetime, breed varchar(255) not null, color varchar(255), gender varchar(255) not null, hidden bit, name varchar(255) not null, sterilized bit, primary key (id)) engine=InnoDB;
create table surgeries (id integer not null auto_increment, note varchar(255), pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vaccinations (id integer not null auto_increment, nextDue datetime not null, vaccine_type varchar(255) not null, pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vet_services (id integer not null auto_increment, name varchar(255), price double precision, vet_service_code varchar(255) not null, primary key (id)) engine=InnoDB;
create table veterinarians (id integer not null auto_increment, name varchar(255), specialty varchar(255) not null, vet_service_id integer not null, primary key (id)) engine=InnoDB;
create table visits (id integer not null auto_increment, blood_pressure varchar(255), date datetime not null, diagnosis varchar(255), pulse integer, temp double precision, weight double precision, appointment_id integer, pet_record_id integer not null, primary key (id)) engine=InnoDB;
alter table appointments add constraint FKp5c590sq8rdlq0rig06qpul2 foreign key (available_time_id) references available_times (id);
alter table appointments add constraint FK62dl3dvwsbveq3vv067becwmj foreign key (pet_id) references pets (id);
alter table appointments add constraint FKrbtlfqnkbi99fihd937thl9ki foreign key (service_id) references vet_services (id);
alter table available_times add constraint FKgmp9yqkddpdtwfo0og1seb74p foreign key (veterinarian_id) references veterinarians (id);
alter table conditions add constraint FKju5n46v5hpq54aia5umn9hux6 foreign key (pet_record_id) references pet_records (id);
alter table owned_pets add constraint FKt09bl30jm92dgdj19svi5stj9 foreign key (pet_id) references pets (id);
alter table pet_records add constraint FK2gy9tek1o73k0vyg6sftufffk foreign key (pet_id) references pets (id);
alter table surgeries add constraint FKlqro63kh1r3vxkxoyrttthi9a foreign key (pet_record_id) references pet_records (id);
alter table surgeries add constraint FK11tymkajjhxa2std9cb58t2o4 foreign key (visit_id) references visits (id);
alter table vaccinations add constraint FKh08dj88fb4atdb3jfwqf68nyx foreign key (pet_record_id) references pet_records (id);
alter table vaccinations add constraint FKrjlx3qx6borapu1yiehqtsid8 foreign key (visit_id) references visits (id);
alter table veterinarians add constraint FK98l7t8njgt1r5wnh2dy4egeud foreign key (vet_service_id) references vet_services (id);
alter table visits add constraint FKfpy5talf3e95w9iie6gr8emsy foreign key (appointment_id) references appointments (id);
alter table visits add constraint FKo4k5phr36co6squ5l5njueua3 foreign key (pet_record_id) references pet_records (id);
create table appointments (id integer not null auto_increment, canceled bit, owners_comment varchar(255), available_time_id integer not null, pet_id integer not null, service_id integer not null, primary key (id)) engine=InnoDB;
create table available_times (id integer not null auto_increment, booked bit, date datetime not null, veterinarian_id integer not null, primary key (id)) engine=InnoDB;
create table clients (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table conditions (id integer not null auto_increment, condition_name varchar(255) not null, note varchar(255), pet_record_id integer not null, primary key (id)) engine=InnoDB;
create table owned_pets (id integer not null auto_increment, pet_owner_id varchar(255) not null, pet_id integer, primary key (id)) engine=InnoDB;
create table pet_owners (id varchar(255) not null, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table pet_records (id integer not null auto_increment, pet_id integer not null, primary key (id)) engine=InnoDB;
create table pets (id integer not null auto_increment, birthday datetime, breed varchar(255) not null, color varchar(255), gender varchar(255) not null, hidden bit, name varchar(255) not null, sterilized bit, primary key (id)) engine=InnoDB;
create table surgeries (id integer not null auto_increment, note varchar(255), pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vaccinations (id integer not null auto_increment, nextDue datetime not null, vaccine_type varchar(255) not null, pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vet_services (id integer not null auto_increment, name varchar(255), price double precision, vet_service_code varchar(255) not null, primary key (id)) engine=InnoDB;
create table veterinarians (id integer not null auto_increment, name varchar(255), specialty varchar(255) not null, vet_service_id integer not null, primary key (id)) engine=InnoDB;
create table visits (id integer not null auto_increment, blood_pressure varchar(255), date datetime not null, diagnosis varchar(255), pulse integer, temp double precision, weight double precision, appointment_id integer, pet_record_id integer not null, primary key (id)) engine=InnoDB;
alter table appointments add constraint FKp5c590sq8rdlq0rig06qpul2 foreign key (available_time_id) references available_times (id);
alter table appointments add constraint FK62dl3dvwsbveq3vv067becwmj foreign key (pet_id) references pets (id);
alter table appointments add constraint FKrbtlfqnkbi99fihd937thl9ki foreign key (service_id) references vet_services (id);
alter table available_times add constraint FKgmp9yqkddpdtwfo0og1seb74p foreign key (veterinarian_id) references veterinarians (id);
alter table conditions add constraint FKju5n46v5hpq54aia5umn9hux6 foreign key (pet_record_id) references pet_records (id);
alter table owned_pets add constraint FKt09bl30jm92dgdj19svi5stj9 foreign key (pet_id) references pets (id);
alter table pet_records add constraint FK2gy9tek1o73k0vyg6sftufffk foreign key (pet_id) references pets (id);
alter table surgeries add constraint FKlqro63kh1r3vxkxoyrttthi9a foreign key (pet_record_id) references pet_records (id);
alter table surgeries add constraint FK11tymkajjhxa2std9cb58t2o4 foreign key (visit_id) references visits (id);
alter table vaccinations add constraint FKh08dj88fb4atdb3jfwqf68nyx foreign key (pet_record_id) references pet_records (id);
alter table vaccinations add constraint FKrjlx3qx6borapu1yiehqtsid8 foreign key (visit_id) references visits (id);
alter table veterinarians add constraint FK98l7t8njgt1r5wnh2dy4egeud foreign key (vet_service_id) references vet_services (id);
alter table visits add constraint FKfpy5talf3e95w9iie6gr8emsy foreign key (appointment_id) references appointments (id);
alter table visits add constraint FKo4k5phr36co6squ5l5njueua3 foreign key (pet_record_id) references pet_records (id);
