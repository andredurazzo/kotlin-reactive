create table TRAINER (
	id Serial primary key,
	name varchar(255) unique,
	birthdate Date not null,
	created_at TIMESTAMP not null,
	updated_at TIMESTAMP,
	nick_name varchar 
)

create table pokemon_types(
	id Serial primary key,
	name varchar not null
)

create table Pokemon(
	id Serial primary key,
	name varchar unique not null,
	types pokemon_types[2],
	evolution_by integer,
	has_evolution boolean default value FALSE,
	evolve_level integer,
	foreign key (evolution_by) references pokemon(id)
)

create table pokemon_details(
    pokemon_id integer primary key,
    hit_point integer,
    attack integer,
    defense integer,
    special_attack integer,
    special_defense integer,
    speed integer,
    foreign key (pokemon_id) references pokemon(id)
)

create table Trainer_catcher(
	id Serial primary key,
	trainer_id integer,
	pokemon_id integer,
	foreign key (trainer_id) references Trainer,
	foreign key (pokemon_id) references pokemon
)

create table caught_details(
	id serial primary key,
	name_pokemon varchar not null,
	catcher_id integer,
	level_catcher integer not null,
	current_level integer,
	create_at timestamp,
	update_at timestamp,
	foreign key (catcher_id) references trainer_catcher
)


insert into pokemon_types(NAME) values ('NORMAL');
insert into pokemon_types(NAME) values ('WATER');
insert into pokemon_types(NAME) values ('ELECTRIC');
insert into pokemon_types(NAME) values ('FIGHT');
insert into pokemon_types(NAME) values ('GROUND');
insert into pokemon_types(NAME) values ('PSYCHIC');
insert into pokemon_types(NAME) values ('ROCK');
insert into pokemon_types(NAME) values ('DARK');
insert into pokemon_types(NAME) values ('STEEL');
insert into pokemon_types(NAME) values ('FIRE');
insert into pokemon_types(NAME) values ('GRASS');
insert into pokemon_types(NAME) values ('ICE');
insert into pokemon_types(NAME) values ('POISON');
insert into pokemon_types(NAME) values ('FLYING');
insert into pokemon_types(NAME) values ('BUG');
insert into pokemon_types(NAME) values ('GHOST');
insert into pokemon_types(NAME) values ('DRAGON');
insert into pokemon_types(NAME) values ('FAIRY');

