package uniovi.innova.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uniovi.innova.classes.factories.Factory;
import uniovi.innova.classes.services.IPortalesService;
 
@ManagedBean
public class VisitsPortletView {
	   
    private String portal;
  

	private Map <String,String> portales;
	protected IPortalesService portalService;
	protected BeanFactory factory;
	protected Factory factoryService;

	@PostConstruct
    public void init() {
    	factory = new ClassPathXmlApplicationContext("beans.xml");
 		factoryService = (Factory) factory.getBean("factory");
		portalService = factoryService.getServicePortales();
		portales = portalService.getPortales();

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

    
}
