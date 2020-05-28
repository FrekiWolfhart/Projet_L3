# Projet_L3

Pour faire fonctionner le projet, vous aurez besoin de Lombok (qui sert à utiliser des annotations pour générer les getters, setters, equals, HashCode...)
https://projectlombok.org/setup/overview

Vous aurez aussi besoin de maveniser le projet pour gérer les dépendances

Il vous faudra une base de donnée postgreSQL (sur le port 34304 par défault, mais vous pouvez changer ce port dans src/config/hibernate.cfg.xml)
pour mettre en place la BDD, exécutez d'abord BDD/create_table.sql, puis create_user.sql


Utilisez restful.Main pour excéuter l'API (vous pourez ensuite l'utiliser directement dans votre navigateur ou depuis postman en vous connectant sur le port 8080)


Si vous voulez tester des services sans passer par l'API, vous pouvez utiliser test.java.Demonstration en modifiant la méthode init()
Les services annotés avec @autowired seront injectés automatiquement grace à Spring
