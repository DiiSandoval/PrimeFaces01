package uniovi.innova.classes.model;

public class Operativo {

	private String nombre;
	private String visitas;


	public Operativo(String nombre, String visitas) {
		super();
		this.nombre = nombre;
		this.visitas = visitas;
	}

	public Operativo() {
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
