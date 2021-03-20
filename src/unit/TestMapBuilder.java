package unit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.junit.Test;
import process.Ant;
import process.MapBuilder;
import data.MapCharacteristics;

/**
 * This class allows the test of the class MapBuilder
 * 
 * @author Edson De Carvalho
 *
 */
public class TestMapBuilder {

	@Test
	public void testCreatAnt() throws IOException, URISyntaxException {
		
		MapCharacteristics mapCharacteristics =  MapCharacteristics.getInstance(); 
		mapCharacteristics.setXmax(300);
		mapCharacteristics.setYmax(300);
		
		MapBuilder f=new MapBuilder(null);
		ArrayList<Ant> ants= new ArrayList<Ant>();
		for(int i=0;i<2;i++) {
			ants=f.recreateAnt(ants);
		}
		assertEquals(ants.size(),2);
		
	}

}
