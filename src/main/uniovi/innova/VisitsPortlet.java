package main.uniovi.innova;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import main.uniovi.innova.factories.Factory;
import main.uniovi.innova.services.ga.IGAService;
import main.uniovi.innova.services.ga.IPortalesService;
import main.uniovi.innova.services.ga.implementation.util.DateFormat;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VisitsPortlet extends GenericPortlet {

	protected IGAService gaServiceNewData;
	protected IGAService gaServiceOldData;
	protected IPortalesService portalService;
	protected BeanFactory factory;
	protected Factory factoryService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.GenericPortlet#init()
	 */
	public void init() {
		factory = new ClassPathXmlApplicationContext("beans.xml");
		factoryService = (Factory) factory.getBean("factory");
		gaServiceNewData = factoryService.getServiceGoogleAnalyticsNewData();
		gaServiceOldData = factoryService.getServiceGoogleAnalyticsOldData();
		portalService = factoryService.getServicePortales();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest,
	 * javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		String id = "UA-376062-58";
		gaServiceNewData.setUA(id);
		request.setAttribute("mapPortal", portalService.getPortales());
		include("/html/view.jsp", request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.portlet.GenericPortlet#processAction(javax.portlet.ActionRequest,
	 * javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(ActionRequest actionrequest,
			ActionResponse actionResponse) {

		int monthStart = Integer.parseInt(actionrequest
				.getParameter("month_start"));
		int dayStart = Integer
				.parseInt(actionrequest.getParameter("day_start"));
		int yearStart = Integer.parseInt(actionrequest
				.getParameter("year_start"));
		int monthEnd = Integer
				.parseInt(actionrequest.getParameter("month_end"));
		int dayEnd = Integer.parseInt(actionrequest.getParameter("day_end"));
		int yearEnd = Integer.parseInt(actionrequest.getParameter("year_end"));

		IGAService gaService = null;
		if (DateFormat.isFechaActual(dayStart, monthStart, yearStart, dayEnd,
				monthEnd, yearEnd))
			gaService = gaServiceNewData;
		else
			gaService = gaServiceOldData;

		String id = "UA-376062-58";
		gaService.setUA(id);
		actionrequest.setAttribute("numVisitasIntervalo", gaService
				.numOfVisitsBetweenTwoDates(id, dayStart, monthStart,
						yearStart, dayEnd, monthEnd, yearEnd));
		actionrequest
				.setAttribute("mapCountry", gaService.getVisitsByCountry(id,
						dayStart, monthStart, yearStart, dayEnd, monthEnd,
						yearEnd));
		actionrequest.setAttribute("mapSO", gaService.getVisitsBySSOO(id,
				dayStart, monthStart, yearStart, dayEnd, monthEnd, yearEnd));
		actionrequest.setAttribute("mapPages", gaService.getPageVisits(id,
				dayStart, monthStart, yearStart, dayEnd, monthEnd, yearEnd));

	}

	/**
	 * @param path
	 * @param renderRequest
	 * @param renderResponse
	 * @throws IOException
	 * @throws PortletException
	 * Method include of Visit Portlet
	 */
	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			System.err.println(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

}
