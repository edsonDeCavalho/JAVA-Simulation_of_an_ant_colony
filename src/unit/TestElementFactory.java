package unit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import data.BigFood;
import data.GreenRock;
import data.BlackRock;
import data.SmallFood;
import process.Ant;
import process.ElementFactory;
import process.Predator;

/**
 * This class allows the test of the class ElementFactory
 * 
 * @author Edson De Carvalho
 *
 */
public class TestElementFactory {

	@Test
	public void testCreatAnt() throws IOException, URISyntaxException {
		Ant a= new Ant(1,1,0);
		Ant b =ElementFactory.creatAnt(1, 1, 0);
		assertEquals(a.getType(), b.getType());
		
	}
	
	@Test
	public void testCreaObstacleNonLethal() throws IOException, URISyntaxException {
		BlackRock a= new BlackRock(1,1);
		BlackRock b =ElementFactory.creatBlackRock(1, 1);
		assertEquals(a.getType(), b.getType());
		
	}
	
	@Test
	public void testCreatObstacleLethal() throws IOException, URISyntaxException {
		GreenRock a= new GreenRock(1,1);
		GreenRock b =ElementFactory.creatGreenRock(1, 1);
		assertEquals(a.getType(), b.getType());
		
	}
	
	@Test
	public void testCreatSmallFood() throws IOException, URISyntaxException {
		SmallFood a= new SmallFood(1,1,0);
		SmallFood b =ElementFactory.creatSmallFood(1, 1,0);
		assertEquals(a.getType(), b.getType());
		
	}
	
	@Test
	public void testCreatBigFood() throws IOException, URISyntaxException {
		BigFood a= new BigFood(1,1,0);
		BigFood b =ElementFactory.creatBigFood(1, 1, 0);
		assertEquals(a.getType(), b.getType());
		
	}
	
	@Test
	public void testCreatPredator() throws IOException, URISyntaxException {
		Predator a= new Predator(1,1);
		Predator b =ElementFactory.creatPredator(1, 1);
		assertEquals(a.getType(), b.getType());
	}

}
