package controleur.implementation;

import java.time.Period;

import org.springframework.stereotype.Service;

import controleur.DureePretService;

@Service("dureePretService")
public class DureePretServiceImplement implements DureePretService {

	@Override
	public Period getDuree() {
		// TODO : utiliser un ficher de configuration https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Properties.html
		return Period.ofMonths(1);
	}
}