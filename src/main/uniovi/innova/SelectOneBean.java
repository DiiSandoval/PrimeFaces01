package main.uniovi.innova;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;



@ManagedBean
public class SelectOneBean implements Serializable {
	private String option;   
    private Theme theme; 
    private List<Theme> themes;
     
    @ManagedProperty("#{themeService}")
    private ThemeService service;
     
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
 
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
 
    public Theme getTheme() {
        return theme;
    }
 
    public void setTheme(Theme theme) {
        this.theme = theme;
    }
 
    public List<Theme> getThemes() {
        return themes;
    }
 
    public void setService(ThemeService service) {
        this.service = service;
    }
}
