package uniovi.innova.classes.factories;

import uniovi.innova.classes.services.IGAService;
import uniovi.innova.classes.services.IPortalesService;

public class Factory {

	private IGAService serviceGoogleAnalyticsNewData;
	private IGAService serviceGoogleAnalyticsOldData;
	private IPortalesService servicePortales;

	public IGAService getServiceGoogleAnalyticsNewData() {
		return serviceGoogleAnalyticsNewData;
	}

	public void setServiceGoogleAnalyticsNewData(
			IGAService serviceGoogleAnalyticsNewData) {
		this.serviceGoogleAnalyticsNewData = serviceGoogleAnalyticsNewData;
	}

	public IGAService getServiceGoogleAnalyticsOldData() {
		return serviceGoogleAnalyticsOldData;
	}

	public void setServiceGoogleAnalyticsOldData(
			IGAService serviceGoogleAnalyticsOldData) {
		this.serviceGoogleAnalyticsOldData = serviceGoogleAnalyticsOldData;
	}

	public IPortalesService getServicePortales() {
		return servicePortales;
	}

	public void setServicePortales(IPortalesService servicePortales) {
		this.servicePortales = servicePortales;
	}



	
	
	
}