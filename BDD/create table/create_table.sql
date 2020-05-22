create table adherent (
	id serial primary key, -- serial = int auto increment 
	nom text,
	prenom text,
	email text,
	date_adhesion timestamp,
	date_paiement timestamp
);

create table oeuvre (
	cote text primary key,
	titre text,
	date_parution date
);

create table autheur ( -- many to many
	nom text,
	cote text references oeuvre(cote),
	primary key(nom, cote)
);

create table reservation (
	id_adherent int refeences adherent(id),
	cote text references oeuvre(cote),
	primary key(id_adherent, cote)
);

create table tag ( -- many to many
	mot text,
	cote text references oeuvre(cote),
	primary key(mot, cote)
);

create table exemplaire (
	cote text references oeuvre(cote),
	numero int, -- todo : faire qu'il s'incrémentente tous seul en fonction du nombre d'exemplaire de ce livre
	primary key(cote, numero),
	date_achat timestamp,
	dernier_pret int
);

create table pret (
	id serial primary key,
	cote text,
	numero_exemplaire int,
	foreign key(cote, numero_exemplaire) references exemplaire(cote, numero),
	date_emprunt timestamp not null,
	duree_theorique interval not null,
	date_rendu timestamp
);

alter table exemplaire
add FOREIGN KEY (dernier_pret) references pret(id);



