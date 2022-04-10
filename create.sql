create table appointments (id integer not null auto_increment, canceled bit, owners_comment varchar(255), available_time_id integer not null, pet_id integer not null, service_id integer not null, primary key (id)) engine=InnoDB;
create table available_time (id integer not null auto_increment, date datetime, doctor_id integer, primary key (id)) engine=InnoDB;
create table clients (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table conditions (id integer not null auto_increment, condition_name varchar(255) not null, note varchar(255), pet_record_id integer not null, primary key (id)) engine=InnoDB;
create table doctors (id integer not null auto_increment, name varchar(255), specialty varchar(255) not null, primary key (id)) engine=InnoDB;
create table owned_pets (id integer not null auto_increment, pet_id integer, pet_owner_id integer, primary key (id)) engine=InnoDB;
create table pet_owners (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table pet_record (id integer not null auto_increment, pet_id integer not null, primary key (id)) engine=InnoDB;
create table pets (id integer not null auto_increment, birthday datetime, breed varchar(255) not null, color varchar(255), gender varchar(255) not null, hidden bit, name varchar(255) not null, sterilized bit, primary key (id)) engine=InnoDB;
create table surgeries (id integer not null auto_increment, note varchar(255), pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vaccinations (id integer not null auto_increment, nextDue integer not null, vaccine_type varchar(255) not null, pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vet_services (id integer not null auto_increment, name varchar(255), price double precision, doctor_id integer not null, primary key (id)) engine=InnoDB;
create table visits (id integer not null auto_increment, blood_pressure varchar(255), date datetime not null, diagnosis varchar(255), pulse integer, temp double precision, weight double precision, appointment_id integer not null, pet_record_id integer not null, primary key (id)) engine=InnoDB;
alter table appointments add constraint FKmlju9bekaic3huiq36q3ar1de foreign key (available_time_id) references available_time (id);
alter table appointments add constraint FK62dl3dvwsbveq3vv067becwmj foreign key (pet_id) references pets (id);
alter table appointments add constraint FKrbtlfqnkbi99fihd937thl9ki foreign key (service_id) references vet_services (id);
alter table available_time add constraint FKrrq9wasd65dpkhy44655fimji foreign key (doctor_id) references doctors (id);
alter table conditions add constraint FK5n856okl5miu0qlyrcrmo4hjj foreign key (pet_record_id) references pet_record (id);
alter table owned_pets add constraint FKt09bl30jm92dgdj19svi5stj9 foreign key (pet_id) references pets (id);
alter table owned_pets add constraint FK5boe05mpswoa1hjl7cakw9io7 foreign key (pet_owner_id) references pet_owners (id);
alter table pet_record add constraint FKerh8xft6p5y0559af98116skw foreign key (pet_id) references pets (id);
alter table surgeries add constraint FKgiv4r9ro1rep93yujq9hh8vjx foreign key (pet_record_id) references pet_record (id);
alter table surgeries add constraint FK11tymkajjhxa2std9cb58t2o4 foreign key (visit_id) references visits (id);
alter table vaccinations add constraint FK80brb4ffdrcyhtyvhgqxljchq foreign key (pet_record_id) references pet_record (id);
alter table vaccinations add constraint FKrjlx3qx6borapu1yiehqtsid8 foreign key (visit_id) references visits (id);
alter table vet_services add constraint FKmd4m0uw9jxjba8iycwr2ohpjc foreign key (doctor_id) references doctors (id);
alter table visits add constraint FKfpy5talf3e95w9iie6gr8emsy foreign key (appointment_id) references appointments (id);
alter table visits add constraint FKt6jud9i0kueba647711cac7qn foreign key (pet_record_id) references pet_record (id);
create table appointments (id integer not null auto_increment, canceled bit, owners_comment varchar(255), available_time_id integer not null, pet_id integer not null, service_id integer not null, primary key (id)) engine=InnoDB;
create table available_time (id integer not null auto_increment, date datetime, doctor_id integer, primary key (id)) engine=InnoDB;
create table clients (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table conditions (id integer not null auto_increment, condition_name varchar(255) not null, note varchar(255), pet_record_id integer not null, primary key (id)) engine=InnoDB;
create table doctors (id integer not null auto_increment, name varchar(255), specialty varchar(255) not null, primary key (id)) engine=InnoDB;
create table owned_pets (id integer not null auto_increment, pet_id integer, pet_owner_id integer, primary key (id)) engine=InnoDB;
create table pet_owners (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table pet_record (id integer not null auto_increment, pet_id integer not null, primary key (id)) engine=InnoDB;
create table pets (id integer not null auto_increment, birthday datetime, breed varchar(255) not null, color varchar(255), gender varchar(255) not null, hidden bit, name varchar(255) not null, sterilized bit, primary key (id)) engine=InnoDB;
create table surgeries (id integer not null auto_increment, note varchar(255), pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vaccinations (id integer not null auto_increment, nextDue integer not null, vaccine_type varchar(255) not null, pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vet_services (id integer not null auto_increment, name varchar(255), price double precision, doctor_id integer not null, primary key (id)) engine=InnoDB;
create table visits (id integer not null auto_increment, blood_pressure varchar(255), date datetime not null, diagnosis varchar(255), pulse integer, temp double precision, weight double precision, appointment_id integer not null, pet_record_id integer not null, primary key (id)) engine=InnoDB;
alter table appointments add constraint FKmlju9bekaic3huiq36q3ar1de foreign key (available_time_id) references available_time (id);
alter table appointments add constraint FK62dl3dvwsbveq3vv067becwmj foreign key (pet_id) references pets (id);
alter table appointments add constraint FKrbtlfqnkbi99fihd937thl9ki foreign key (service_id) references vet_services (id);
alter table available_time add constraint FKrrq9wasd65dpkhy44655fimji foreign key (doctor_id) references doctors (id);
alter table conditions add constraint FK5n856okl5miu0qlyrcrmo4hjj foreign key (pet_record_id) references pet_record (id);
alter table owned_pets add constraint FKt09bl30jm92dgdj19svi5stj9 foreign key (pet_id) references pets (id);
alter table owned_pets add constraint FK5boe05mpswoa1hjl7cakw9io7 foreign key (pet_owner_id) references pet_owners (id);
alter table pet_record add constraint FKerh8xft6p5y0559af98116skw foreign key (pet_id) references pets (id);
alter table surgeries add constraint FKgiv4r9ro1rep93yujq9hh8vjx foreign key (pet_record_id) references pet_record (id);
alter table surgeries add constraint FK11tymkajjhxa2std9cb58t2o4 foreign key (visit_id) references visits (id);
alter table vaccinations add constraint FK80brb4ffdrcyhtyvhgqxljchq foreign key (pet_record_id) references pet_record (id);
alter table vaccinations add constraint FKrjlx3qx6borapu1yiehqtsid8 foreign key (visit_id) references visits (id);
alter table vet_services add constraint FKmd4m0uw9jxjba8iycwr2ohpjc foreign key (doctor_id) references doctors (id);
alter table visits add constraint FKfpy5talf3e95w9iie6gr8emsy foreign key (appointment_id) references appointments (id);
alter table visits add constraint FKt6jud9i0kueba647711cac7qn foreign key (pet_record_id) references pet_record (id);
create table appointments (id integer not null auto_increment, canceled bit, owners_comment varchar(255), available_time_id integer not null, pet_id integer not null, service_id integer not null, primary key (id)) engine=InnoDB;
create table available_time (id integer not null auto_increment, date datetime, doctor_id integer, primary key (id)) engine=InnoDB;
create table clients (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table conditions (id integer not null auto_increment, condition_name varchar(255) not null, note varchar(255), pet_record_id integer not null, primary key (id)) engine=InnoDB;
create table doctors (id integer not null auto_increment, name varchar(255), specialty varchar(255) not null, primary key (id)) engine=InnoDB;
create table owned_pets (id integer not null auto_increment, pet_id integer, pet_owner_id integer, primary key (id)) engine=InnoDB;
create table pet_owners (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table pet_record (id integer not null auto_increment, pet_id integer not null, primary key (id)) engine=InnoDB;
create table pets (id integer not null auto_increment, birthday datetime, breed varchar(255) not null, color varchar(255), gender varchar(255) not null, hidden bit, name varchar(255) not null, sterilized bit, primary key (id)) engine=InnoDB;
create table surgeries (id integer not null auto_increment, note varchar(255), pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vaccinations (id integer not null auto_increment, nextDue integer not null, vaccine_type varchar(255) not null, pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vet_services (id integer not null auto_increment, name varchar(255), price double precision, doctor_id integer not null, primary key (id)) engine=InnoDB;
create table visits (id integer not null auto_increment, blood_pressure varchar(255), date datetime not null, diagnosis varchar(255), pulse integer, temp double precision, weight double precision, appointment_id integer, pet_record_id integer not null, primary key (id)) engine=InnoDB;
alter table appointments add constraint FKmlju9bekaic3huiq36q3ar1de foreign key (available_time_id) references available_time (id);
alter table appointments add constraint FK62dl3dvwsbveq3vv067becwmj foreign key (pet_id) references pets (id);
alter table appointments add constraint FKrbtlfqnkbi99fihd937thl9ki foreign key (service_id) references vet_services (id);
alter table available_time add constraint FKrrq9wasd65dpkhy44655fimji foreign key (doctor_id) references doctors (id);
alter table conditions add constraint FK5n856okl5miu0qlyrcrmo4hjj foreign key (pet_record_id) references pet_record (id);
alter table owned_pets add constraint FKt09bl30jm92dgdj19svi5stj9 foreign key (pet_id) references pets (id);
alter table owned_pets add constraint FK5boe05mpswoa1hjl7cakw9io7 foreign key (pet_owner_id) references pet_owners (id);
alter table pet_record add constraint FKerh8xft6p5y0559af98116skw foreign key (pet_id) references pets (id);
alter table surgeries add constraint FKgiv4r9ro1rep93yujq9hh8vjx foreign key (pet_record_id) references pet_record (id);
alter table surgeries add constraint FK11tymkajjhxa2std9cb58t2o4 foreign key (visit_id) references visits (id);
alter table vaccinations add constraint FK80brb4ffdrcyhtyvhgqxljchq foreign key (pet_record_id) references pet_record (id);
alter table vaccinations add constraint FKrjlx3qx6borapu1yiehqtsid8 foreign key (visit_id) references visits (id);
alter table vet_services add constraint FKmd4m0uw9jxjba8iycwr2ohpjc foreign key (doctor_id) references doctors (id);
alter table visits add constraint FKfpy5talf3e95w9iie6gr8emsy foreign key (appointment_id) references appointments (id);
alter table visits add constraint FKt6jud9i0kueba647711cac7qn foreign key (pet_record_id) references pet_record (id);
create table appointments (id integer not null auto_increment, canceled bit, owners_comment varchar(255), available_time_id integer not null, pet_id integer not null, service_id integer not null, primary key (id)) engine=InnoDB;
create table available_time (id integer not null auto_increment, date datetime, doctor_id integer, primary key (id)) engine=InnoDB;
create table clients (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table conditions (id integer not null auto_increment, condition_name varchar(255) not null, note varchar(255), pet_record_id integer not null, primary key (id)) engine=InnoDB;
create table doctors (id integer not null auto_increment, name varchar(255), specialty varchar(255) not null, primary key (id)) engine=InnoDB;
create table owned_pets (id integer not null auto_increment, pet_id integer, pet_owner_id integer, primary key (id)) engine=InnoDB;
create table pet_owners (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table pet_record (id integer not null auto_increment, pet_id integer not null, primary key (id)) engine=InnoDB;
create table pets (id integer not null auto_increment, birthday datetime, breed varchar(255) not null, color varchar(255), gender varchar(255) not null, hidden bit, name varchar(255) not null, sterilized bit, primary key (id)) engine=InnoDB;
create table surgeries (id integer not null auto_increment, note varchar(255), pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vaccinations (id integer not null auto_increment, nextDue integer not null, vaccine_type varchar(255) not null, pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vet_services (id integer not null auto_increment, name varchar(255), price double precision, doctor_id integer not null, primary key (id)) engine=InnoDB;
create table visits (id integer not null auto_increment, blood_pressure varchar(255), date datetime not null, diagnosis varchar(255), pulse integer, temp double precision, weight double precision, appointment_id integer, pet_record_id integer not null, primary key (id)) engine=InnoDB;
alter table appointments add constraint FKmlju9bekaic3huiq36q3ar1de foreign key (available_time_id) references available_time (id);
alter table appointments add constraint FK62dl3dvwsbveq3vv067becwmj foreign key (pet_id) references pets (id);
alter table appointments add constraint FKrbtlfqnkbi99fihd937thl9ki foreign key (service_id) references vet_services (id);
alter table available_time add constraint FKrrq9wasd65dpkhy44655fimji foreign key (doctor_id) references doctors (id);
alter table conditions add constraint FK5n856okl5miu0qlyrcrmo4hjj foreign key (pet_record_id) references pet_record (id);
alter table owned_pets add constraint FKt09bl30jm92dgdj19svi5stj9 foreign key (pet_id) references pets (id);
alter table owned_pets add constraint FK5boe05mpswoa1hjl7cakw9io7 foreign key (pet_owner_id) references pet_owners (id);
alter table pet_record add constraint FKerh8xft6p5y0559af98116skw foreign key (pet_id) references pets (id);
alter table surgeries add constraint FKgiv4r9ro1rep93yujq9hh8vjx foreign key (pet_record_id) references pet_record (id);
alter table surgeries add constraint FK11tymkajjhxa2std9cb58t2o4 foreign key (visit_id) references visits (id);
alter table vaccinations add constraint FK80brb4ffdrcyhtyvhgqxljchq foreign key (pet_record_id) references pet_record (id);
alter table vaccinations add constraint FKrjlx3qx6borapu1yiehqtsid8 foreign key (visit_id) references visits (id);
alter table vet_services add constraint FKmd4m0uw9jxjba8iycwr2ohpjc foreign key (doctor_id) references doctors (id);
alter table visits add constraint FKfpy5talf3e95w9iie6gr8emsy foreign key (appointment_id) references appointments (id);
alter table visits add constraint FKt6jud9i0kueba647711cac7qn foreign key (pet_record_id) references pet_record (id);
create table appointments (id integer not null auto_increment, canceled bit, owners_comment varchar(255), available_time_id integer not null, pet_id integer not null, service_id integer not null, primary key (id)) engine=InnoDB;
create table available_time (id integer not null auto_increment, date datetime, doctor_id integer, primary key (id)) engine=InnoDB;
create table clients (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table conditions (id integer not null auto_increment, condition_name varchar(255) not null, note varchar(255), pet_record_id integer not null, primary key (id)) engine=InnoDB;
create table doctors (id integer not null auto_increment, name varchar(255), specialty varchar(255) not null, primary key (id)) engine=InnoDB;
create table owned_pets (id integer not null auto_increment, pet_id integer, pet_owner_id integer, primary key (id)) engine=InnoDB;
create table pet_owners (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table pet_record (id integer not null auto_increment, pet_id integer not null, primary key (id)) engine=InnoDB;
create table pets (id integer not null auto_increment, birthday datetime, breed varchar(255) not null, color varchar(255), gender varchar(255) not null, hidden bit, name varchar(255) not null, sterilized bit, primary key (id)) engine=InnoDB;
create table surgeries (id integer not null auto_increment, note varchar(255), pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vaccinations (id integer not null auto_increment, nextDue integer not null, vaccine_type varchar(255) not null, pet_record_id integer not null, visit_id integer not null, primary key (id)) engine=InnoDB;
create table vet_services (id integer not null auto_increment, name varchar(255), price double precision, doctor_id integer not null, primary key (id)) engine=InnoDB;
create table visits (id integer not null auto_increment, blood_pressure varchar(255), date datetime not null, diagnosis varchar(255), pulse integer, temp double precision, weight double precision, appointment_id integer, pet_record_id integer not null, primary key (id)) engine=InnoDB;
alter table appointments add constraint FKmlju9bekaic3huiq36q3ar1de foreign key (available_time_id) references available_time (id);
alter table appointments add constraint FK62dl3dvwsbveq3vv067becwmj foreign key (pet_id) references pets (id);
alter table appointments add constraint FKrbtlfqnkbi99fihd937thl9ki foreign key (service_id) references vet_services (id);
alter table available_time add constraint FKrrq9wasd65dpkhy44655fimji foreign key (doctor_id) references doctors (id);
alter table conditions add constraint FK5n856okl5miu0qlyrcrmo4hjj foreign key (pet_record_id) references pet_record (id);
alter table owned_pets add constraint FKt09bl30jm92dgdj19svi5stj9 foreign key (pet_id) references pets (id);
alter table owned_pets add constraint FK5boe05mpswoa1hjl7cakw9io7 foreign key (pet_owner_id) references pet_owners (id);
alter table pet_record add constraint FKerh8xft6p5y0559af98116skw foreign key (pet_id) references pets (id);
alter table surgeries add constraint FKgiv4r9ro1rep93yujq9hh8vjx foreign key (pet_record_id) references pet_record (id);
alter table surgeries add constraint FK11tymkajjhxa2std9cb58t2o4 foreign key (visit_id) references visits (id);
alter table vaccinations add constraint FK80brb4ffdrcyhtyvhgqxljchq foreign key (pet_record_id) references pet_record (id);
alter table vaccinations add constraint FKrjlx3qx6borapu1yiehqtsid8 foreign key (visit_id) references visits (id);
alter table vet_services add constraint FKmd4m0uw9jxjba8iycwr2ohpjc foreign key (doctor_id) references doctors (id);
alter table visits add constraint FKfpy5talf3e95w9iie6gr8emsy foreign key (appointment_id) references appointments (id);
alter table visits add constraint FKt6jud9i0kueba647711cac7qn foreign key (pet_record_id) references pet_record (id);