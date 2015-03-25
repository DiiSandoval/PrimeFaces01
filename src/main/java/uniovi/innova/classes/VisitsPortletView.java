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

@ManagedBean
public class VisitsPortletView {
	protected IPortalesService portalService;
	protected BeanFactory factory;
	protected Factory factoryService;
	protected IGAService gaServiceNewData;
	protected IGAService gaServiceOldData;

	private String portal;
	private Map<String, String> portales;
	private List<Integer> days;
	private List<Integer> months;
	private List<Integer> years;
	private int visitasPrueba;
	private String id = "UA-376062-58";

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
		setVisitasPrueba(gaServiceNewData
				.numOfVisitsBetweenTwoDates(id, 12, 11,
						2013, 13, 11, 2015));
		

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

	public int getVisitasPrueba() {
		return visitasPrueba;
	}

	public void setVisitasPrueba(int visitasPrueba) {
		this.visitasPrueba = visitasPrueba;
	}

}
