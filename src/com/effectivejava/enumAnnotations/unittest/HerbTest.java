/**
 * Added demo for the "Use EnumMap instead of ordinal indexing".
 */
package com.effectivejava.enumAnnotations.unittest;



import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.effectivejava.enumAnnotations.Herb;

/**
 * @author Kaibo
 * 
 */
public class HerbTest {

	@Test
	public void test() {
		// Using ordinal() to index an array - DON'T DO THIS!
		Herb[] garden = {new Herb("Flower1",Herb.Type.ANNUAL),
				new Herb("Flower2",Herb.Type.BIENNIAL),
				new Herb("Flower3",Herb.Type.BIENNIAL)} ;
		// Using an EnumMap to associate data with an enum
		Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<Herb.Type, Set<Herb>>(
				Herb.Type.class);
		for (Herb.Type t : Herb.Type.values())
			herbsByType.put(t, new HashSet<Herb>());
		for (Herb h : garden)
			herbsByType.get(h.type).add(h);
		System.out.println(herbsByType);
	}

}
