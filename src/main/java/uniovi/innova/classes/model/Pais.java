package uniovi.innova.classes.model;

public class Pais {

	private String nombre;
	private String visitas;



	public Pais(String nombre, String visitas) {
		super();
		this.nombre = nombre;
		this.visitas = visitas;
	}

	public Pais() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getVisitas() {
		return visitas;
	}

	public void setVisitas(String visitas) {
		this.visitas = visitas;
	}
}
