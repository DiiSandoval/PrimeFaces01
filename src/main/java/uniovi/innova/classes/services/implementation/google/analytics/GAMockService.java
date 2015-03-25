package uniovi.innova.classes.services.implementation.google.analytics;

import java.util.Map;

import uniovi.innova.classes.services.IGAService;


public  class GAMockService implements IGAService {

	public int numOfVisitsByDay(String id, int day, int month, int year) {
		return (int) Math.random() * 250;
	}

	public int numOfVisitsByMonth(String id, int month, int year) {
		return (int) Math.random() * 10000;
	}

	public int numOfVisitsByYear(String id, int year) {
		return (int) Math.random() * 10000000;
	}

	public void setUA(String uA) {
	}

	public String getUA() {
		return "";
	}

	public int numOfVisitsBetweenTwoDates(String id, int day_before, int month_before,
			int year_before, int day_after, int month_after, int year_after) {
		return (int) Math.random() * 10000000;
	}

	public Map<String, String> getVisitsByCountry(String id, int day_before,
			int month_before, int year_before, int day_after, int month_after,
			int year_after) {
		return null;
	}
	public Map<String, String> getVisitsBySSOO(String id, int day_before,
			int month_before, int year_before, int day_after, int month_after,
			int year_after) {
		return null;
	}

	public Map<String, String> getPageVisits(String id, int day_before, int month_before,
			int year_before, int day_after, int month_after, int year_after) {
		return null;
	}
	

}