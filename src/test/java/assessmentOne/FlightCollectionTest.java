package assessmentOne;

import assessment.one.Airplane;
import assessment.one.Flight;
import assessment.one.FlightCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightCollectionTest
{
    private Flight flightOne;
    private Flight flightTwo;
    private Flight flightThree;
    private Flight flightFour;
    private FlightCollection flightCollection;

    @BeforeEach
    public void setUp()
    {
        FlightCollection.flights = new ArrayList<>();

        Airplane airplaneOne = new Airplane(1001, "Airbus 3800",10,200,15);
        Airplane airplaneTwo = new Airplane(1010, "Boeing 3800",10,200,15);

        // Adding details for first flight
        Timestamp departureTimeOne = Timestamp.valueOf("2020-01-01 10:00:00");
        Timestamp arrivalTimeOne = Timestamp.valueOf("2020-01-01 13:00:00");
        flightOne = new Flight(101,"Sydney","Melbourne", "AI234","Quantas",departureTimeOne,arrivalTimeOne,airplaneOne);
        FlightCollection.flights.add(flightOne);

        // Adding details for second flight
        Timestamp departureTimeTwo = Timestamp.valueOf("2020-01-02 10:00:00");
        Timestamp arrivalTimeTwo = Timestamp.valueOf("2020-01-02 16:00:00");
        flightTwo = new Flight(102,"Brisbane","Melbourne", "BO134","Quantas",departureTimeTwo,arrivalTimeTwo,airplaneTwo);
        FlightCollection.flights.add(flightTwo);

        // Adding details for third flight
        Timestamp departureTimeThree = Timestamp.valueOf("2020-02-04 10:00:00");
        Timestamp arrivalTimeThree = Timestamp.valueOf("2020-02-04 18:00:00");
        flightThree = new Flight(103,"Perth","Melbourne", "BO777","Quantas",departureTimeThree,arrivalTimeThree,airplaneTwo);
        FlightCollection.flights.add(flightThree);

        // Adding details for fourth flight
        Timestamp departureTimeFour = Timestamp.valueOf("2020-05-10 10:00:00");
        Timestamp arrivalTimeFour = Timestamp.valueOf("2020-05-10 19:00:00");
        flightFour = new Flight(104,"Melbourne","Darwin", "AI200","Quantas",departureTimeFour,arrivalTimeFour,airplaneOne);
        FlightCollection.flights.add(flightFour);

        FlightCollection.addFlights(FlightCollection.flights);
    }


    @Test
    public void testGetFlightInfoWithFlightID()
    {
       Flight actualFlight = FlightCollection.getFlightInfo(104);
       assertEquals(flightFour, actualFlight);
    }

    @Test
    public void testGetFlightInfoWithTwoCities()
    {
        Flight actualFlight = FlightCollection.getFlightInfo("Melbourne", "Perth");
        assertEquals(flightThree, actualFlight);
    }

    @Test
    public void testGetFLightInfoWithOneCity()
    {
        Flight actualFlight = FlightCollection.getFlightInfo("Darwin");
        assertEquals(flightFour, actualFlight);
    }
}
