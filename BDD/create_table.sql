drop table if exists pret, exemplaire, tag, reservation, autheur, oeuvre, adherent cascade;


create table adherent (
	id serial primary key, -- serial = int auto increment 
	nom text not null,
	prenom text not null,
	email text not null,
	date_adhesion timestamp not null,
	date_paiement timestamp
);

create table oeuvre (
	cote text primary key,
	titre text not null,
	date_parution date
);

create table autheur ( -- many to many
	nom text not null,
	cote text references oeuvre(cote) not null,
	primary key(nom, cote)
);

create table reservation (
	id_adherent int references adherent(id) not null,
	cote text references oeuvre(cote) not null,
	primary key(id_adherent, cote),
	date_reservation timestamp not null,
	date_proposition timestamp
);

create table tag ( -- many to many
	mot text not null,
	cote text references oeuvre(cote) not null,
	primary key(mot, cote)
);

create table exemplaire (
	cote text references oeuvre(cote) not null,
	numero int not null, -- todo : faire qu'il s'incrémentente tous seul en fonction du nombre d'exemplaire de ce livre
	primary key(cote, numero),
	date_achat timestamp,
	dernier_pret int
);

create table pret (
	id serial primary key,
	cote text,
	numero_exemplaire int,
	foreign key(cote, numero_exemplaire) references exemplaire(cote, numero) match full,
	numero_adherent int references adherent(id) not null,
	date_emprunt timestamp not null,
	duree_theorique interval not null,
	date_rendu timestamp
);

alter table exemplaire
add FOREIGN KEY (dernier_pret) references pret(id);



