delete from adherent cascade;
delete from oeuvre cascade;

alter sequence adherent_id_seq restart;
alter sequence pret_id_seq restart;