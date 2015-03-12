package main.uniovi.innova;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class PrimeFacesPortlet extends GenericPortlet {



	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest,
	 * javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		include("/views/index.xhtml", request, response);
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
