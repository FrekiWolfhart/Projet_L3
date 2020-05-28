package controleur;

import java.util.Collection;
import java.util.stream.Stream;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MyCollectionUtils {
	public <E> Stream<E> stream(Collection<E> collection) {
		return collection == null ? Stream.empty() : collection.stream();
	}
}