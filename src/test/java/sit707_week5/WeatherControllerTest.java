package sit707_week5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

	
	private static WeatherController wController;
	private static double[] hourlyTemperatures;
	private static int nHours;
	
	
	@BeforeClass
	public static void setup() {
		wController = WeatherController.getInstance();
		nHours = wController.getTotalHours();
		hourlyTemperatures = new double[nHours];
		for (int i = 0; i < nHours; i++) {
			hourlyTemperatures[i] = wController.getTemperatureForHour(i+1);
		}
		
	}
	
	@AfterClass
	public static void teardown() {
		if(wController != null) {
			wController.close();
		}
	}
	
	@Test
	public void testStudentIdentity() {
		String studentId = "225138738";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Moksh Bansal";
		Assert.assertNotNull("Student name is null", studentName);
	}

	
	@Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Arrange
        double minTemperature = hourlyTemperatures[0];
        for (int i = 1; i < nHours; i++) {
            if (hourlyTemperatures[i] < minTemperature) {
                minTemperature = hourlyTemperatures[i];
            }
        }

        // Act
        double cachedMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertTrue(minTemperature == cachedMin);
    }
	
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		// Arrange
        double maxTemperature = hourlyTemperatures[0];
        for (int i = 1; i < nHours; i++) {
            if (hourlyTemperatures[i] > maxTemperature) {
                maxTemperature = hourlyTemperatures[i];
            }
        }

        // Act
        double cachedMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertTrue(maxTemperature == cachedMax);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		// Arrange
        double sumTemp = 0;
        for (int i = 0; i < nHours; i++) {
            sumTemp += hourlyTemperatures[i];
        }
        double averageTemp = sumTemp / nHours;

        // Act
        double cachedAverage = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertTrue(averageTemp == cachedAverage);
	}
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
