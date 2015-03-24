package uniovi.innova.classes.services;

import java.util.Map;

import com.liferay.portal.theme.ThemeDisplay;

public interface IPortalesService {
	Map<String, String> getPortales();
	Map<String, String> getPortalesScope(ThemeDisplay themeDisplay);
}
