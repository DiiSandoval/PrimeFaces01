package main.uniovi.innova.services.ga.implementation;

import java.util.Map;

import main.uniovi.innova.services.ga.implementation.google.analytics.GAnalyticsService;
import main.uniovi.innova.services.ga.implementation.portales.APILiferayPortalesDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

/**
 * Class for getting information provided for Google Analytics
 * 
 * @author luisrodrigar - DiiSandoval
 *
 */
public class GAnalyticsServiceOldData extends GAnalyticsService {

	
	final static Logger log = LoggerFactory
			.getLogger(APILiferayPortalesDAO.class);
	/**
	 * Number of visits in one specific day
	 * 
	 * @param day
	 *            - the day of a month
	 * @param month
	 *            - the month of a year
	 * @param year
	 *            - the concrete year
	 */
	@Override
	@Cacheable(value = "pastVisits", key = "#root.methodName.concat(#id.toString()).concat(#day.toString()).concat(#month.toString()).concat(#year.toString())")
	public int numOfVisitsByDay(String id, int day, int month, int year) {
		log.info("> Caché permanente - Numero de visitas en un día");
		return super.numOfVisitsByDay(id,day, month, year);
	}

	/**
	 * Number of visits during a specific month
	 * 
	 * @param month
	 *            - the mont of a year
	 * @param year
	 *            - the concrete year
	 */
	@Override
	@Cacheable(value = "pastVisits", key = "#root.methodName.concat(#id.toString()).concat(#month.toString()).concat(#year.toString())")
	public int numOfVisitsByMonth(String id, int month, int year) {
		log.info("> Caché permanente - Numero de visitas en un mes");
		return super.numOfVisitsByMonth(id,month, year);
	}

	/**
	 * Number of visits during a specific year
	 * 
	 * @param year
	 *            - the year to obtain the total visits
	 */
	@Override
	@Cacheable(value = "pastVisits", key = "#root.methodName.concat(#id.toString()).concat(#year.toString())")
	public int numOfVisitsByYear(String id, int year) {
		log.info("> Caché permanente - Numero de visitas en un año");
		return super.numOfVisitsByYear(id,year);
	}

	/* (non-Javadoc)
	 * @see main.java.es.uniovi.innova.services.ga.implementation.google.analytics.GAnalyticsService#numOfVisitsBetweenTwoDates(int, int, int, int, int, int)
	 */
	@Override
	@Cacheable(value = "pastVisits", key = "#root.methodName.concat(#id.toString()).concat(#day_before.toString()).concat(#month_before.toString())"
			+ ".concat(#year_before.toString()).concat(#day_after.toString()).concat(#month_after.toString()).concat(#year_after.toString())")
	public int numOfVisitsBetweenTwoDates(String id, int day_before, int month_before,
			int year_before, int day_after, int month_after, int year_after) {
		log.info("> Caché permanente - Numero de visitas entre dos fechas");
		return super.numOfVisitsBetweenTwoDates(id,day_before, month_before,
				year_before, day_after, month_after, year_after);

	}

	/* (non-Javadoc)
	 * @see main.java.es.uniovi.innova.services.ga.implementation.google.analytics.GAnalyticsService#getVisitsByCountry(int, int, int, int, int, int)
	 */
	@Override
	@Cacheable(value = "pastVisits", key = "#root.methodName.concat(#id.toString()).concat(#day_before.toString()).concat(#month_before.toString())"
			+ ".concat(#year_before.toString()).concat(#day_after.toString()).concat(#month_after.toString()).concat(#year_after.toString())")
	public Map<String, String> getVisitsByCountry(String id, int day_before,
			int month_before, int year_before, int day_after, int month_after,
			int year_after) {
		log.info("> Caché permanente - Numero de visitas por país");
		return super.getVisitsByCountry(id,day_before, month_before, year_before,
				day_after, month_after, year_after);

	}

	/* (non-Javadoc)
	 * @see main.java.es.uniovi.innova.services.ga.implementation.google.analytics.GAnalyticsService#getVisitsBySSOO(int, int, int, int, int, int)
	 */
	@Override
	@Cacheable(value = "pastVisits", key = "#root.methodName.concat(#id.toString()).concat(#day_before.toString()).concat(#month_before.toString())"
			+ ".concat(#year_before.toString()).concat(#day_after.toString()).concat(#month_after.toString()).concat(#year_after.toString())")
	public Map<String, String> getVisitsBySSOO(String id, int day_before,
			int month_before, int year_before, int day_after, int month_after,
			int year_after) {
		log.info("> Caché permanente - Numero de visitas por sistema operativo");
		return super.getVisitsBySSOO(id,day_before, month_before, year_before,
				day_after, month_after, year_after);

	}

	/* (non-Javadoc)
	 * @see main.java.es.uniovi.innova.services.ga.implementation.google.analytics.GAnalyticsService#getPageVisits(int, int, int, int, int, int)
	 */
	@Override
	@Cacheable(value = "pastVisits", key = "#root.methodName.concat(#id.toString()).concat(#day_before.toString()).concat(#month_before.toString())"
			+ ".concat(#year_before.toString()).concat(#day_after.toString()).concat(#month_after.toString()).concat(#year_after.toString())")
	public Map<String, String> getPageVisits(String id, int day_before, int month_before,
			int year_before, int day_after, int month_after, int year_after) {
		log.info("> Caché permanente - Numero de visitas por pagina");
		return super.getPageVisits(id,day_before, month_before, year_before,
				day_after, month_after, year_after);

	}

}
