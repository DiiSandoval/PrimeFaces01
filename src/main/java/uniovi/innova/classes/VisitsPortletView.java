package uniovi.innova.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;



import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uniovi.innova.classes.factories.Factory;
import uniovi.innova.classes.services.IGAService;
import uniovi.innova.classes.services.IPortalesService;
import uniovi.innova.classes.services.implementation.util.DateFormat;

@ManagedBean
public class VisitsPortletView {
	protected IPortalesService portalService;
	protected BeanFactory factory;
	protected Factory factoryService;
	protected IGAService gaServiceNewData;
	protected IGAService gaServiceOldData;
	protected IGAService gaService;

	private String portal;
	private Map<String, String> portales;
	private List<Integer> days;
	private List<Integer> months;
	private List<Integer> years;
	private String id = "UA-376062-58";
	private int day_start;
	private int month_start;
	private int year_start;
	private int day_end;
	private int month_end;
	private int year_end;
	private int numVisitas;

	@PostConstruct
	public void init() {
		factory = new ClassPathXmlApplicationContext("beans.xml");
		factoryService = (Factory) factory.getBean("factory");
		portalService = factoryService.getServicePortales();
		portales = portalService.getPortales();
		prepareDateSelects();
		gaServiceNewData = factoryService.getServiceGoogleAnalyticsNewData();
		gaServiceOldData = factoryService.getServiceGoogleAnalyticsOldData();
		gaServiceNewData.setUA(id);

		if (DateFormat.isFechaActual(day_start, month_start, year_start, day_end,
				month_end, year_end))
			gaService = gaServiceNewData;
		else
			gaService = gaServiceOldData;

		String id = "UA-376062-58";
		gaService.setUA(id);


	}
	
	public void mostrarDatos(){
		numVisitas = gaService
				.numOfVisitsBetweenTwoDates(id, day_start, month_start,
						year_start, day_end, month_end, year_end);
	}

	public int getDay_start() {
		return day_start;
	}

	public void setDay_start(int day_start) {
		this.day_start = day_start;
	}

	public int getMonth_start() {
		return month_start;
	}

	public void setMonth_start(int month_start) {
		this.month_start = month_start;
	}

	public int getYear_start() {
		return year_start;
	}

	public void setYear_start(int year_start) {
		this.year_start = year_start;
	}

	public int getDay_end() {
		return day_end;
	}

	public void setDay_end(int day_end) {
		this.day_end = day_end;
	}

	public int getMonth_end() {
		return month_end;
	}

	public void setMonth_end(int month_end) {
		this.month_end = month_end;
	}

	public int getYear_end() {
		return year_end;
	}

	public void setYear_end(int year_end) {
		this.year_end = year_end;
	}

	private void prepareDateSelects() {
		days = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			days.add(i);
		}
		months = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			months.add(i);
		}
		years = new ArrayList<Integer>();
		years.add(2013);
		years.add(2014);
		years.add(2015);
	}

	public String getPortal() {
		return portal;
	}

	public void setPortal(String portal) {
		this.portal = portal;
	}

	public Map<String, String> getPortales() {
		return portales;
	}

	public void setPortales(Map<String, String> portales) {
		this.portales = portales;
	}

	public List<Integer> getDays() {
		return days;
	}

	public void setDays(List<Integer> days) {
		this.days = days;
	}

	public List<Integer> getMonths() {
		return months;
	}

	public void setMonths(List<Integer> months) {
		this.months = months;
	}

	public List<Integer> getYears() {
		return years;
	}

	public void setYears(List<Integer> years) {
		this.years = years;
	}

	public int getNumVisitas() {
		return numVisitas;
	}

	public void setNumVisitas(int numVisitas) {
		this.numVisitas = numVisitas;
	}


}
