package assessment.one;

import java.util.ArrayList;

public class FlightCollection {
	
	public static ArrayList<Flight> flights;

	public static ArrayList<Flight> getFlights()
	{
		return flights;
	}

	public static void addFlights(ArrayList<Flight> flights)
	{
		FlightCollection.flights.addAll(flights);
	}
	
	public static Flight getFlightInfo(String city1, String city2)
	{
    	//display the flights where there is a direct flight from city 1 to city2
    	for (Flight flight : flights)
		{
			if (flight.getDepartFrom().equals(city1) && flight.getDepartTo().equals(city2))
			{
				System.out.println(flight.toString());
			}
		};
		return null;
    }
    
    public static Flight getFlightInfo(String city)
	{
    	//SELECT a flight where depart_to = city
    	Flight flight = null;
		for (Flight f : flights)
		{
			if (f.getDepartFrom().equals(city))
			{
				flight = f;
			}
		}
		return flight;
    }
    public static Flight getFlightInfo(int flight_id)
	{
    	//SELECT a flight with a particular flight id
    	Flight flight =  null;

		for (Flight f : flights)
		{
			if (f.getFlightID() == flight_id)
			{
				flight = f;
			}
		}
		return flight;
    }
}
