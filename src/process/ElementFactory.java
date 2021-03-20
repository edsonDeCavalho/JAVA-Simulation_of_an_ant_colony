package process;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.URISyntaxException;

import data.BigFood;
import data.GreenRock;
import data.BlackRock;
import data.SmallFood;
import log.LoggerUtility;
import process.Ant;

/**
 * This class create an instance of a element at a specific position.
 * The class uses simple factory design pattern with static utility methods.
 * 
 * The creation of the elements is recorded by Log4j.
 * 
 * @author Arthur Mimouni, Edson De Carvalho 
 *
 */
public class ElementFactory {
	
	private static Logger logger = LoggerUtility.getLogger(ElementFactory.class, "html");
	
	public static Ant creatAnt(int x,int y,int idNumber) throws IOException, URISyntaxException {
		logger.info("Object Ant creation with the idNumber :  " +idNumber);
		return new Ant(x,y,idNumber);
	}
	
	public static BlackRock creatBlackRock(int x,int y) {
		logger.info("Creation of Object type BlackRock ");
		return new BlackRock(x,y);
	}
	
	public static GreenRock creatGreenRock(int x,int y) {
		logger.info("Creation of Object type GreenRock");
		return new GreenRock(x,y);
	}
	
	public static SmallFood creatSmallFood(int quantity,int x,int y) {
		logger.info("Creation of Object type SmallFood");
		return new SmallFood(quantity,x,y);
	}
	
	public static BigFood creatBigFood(int quantity,int x,int y) {
		logger.info("Creation of Object type BigFood");
		return new BigFood(quantity,x,y);
	}
	
	public static Predator creatPredator(int x,int y){
		logger.info("Creation of Object type Predator");
		return new Predator(x,y);
	}
}
