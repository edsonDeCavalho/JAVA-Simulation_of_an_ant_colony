package unit;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * This class allows the simultaneous test of the classes MapBuilder and ElementFactory
 * 
 * @author Edson De Carvalho
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({TestElementFactory.class, TestMapBuilder.class})


public class AntSimulationTestSuite {

}
