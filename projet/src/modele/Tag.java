package modele;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "tag")
public class Tag implements Serializable {
	@Id
	String tag;
	
	@ManyToMany
	Collection<Oeuvre> oeuvres;
	
	@Override
	public String toString() {
		return getTag();
	}
}
