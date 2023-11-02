package Modelo;

import java.util.ArrayList;

public class Pregunta {
	private String pregunta;
	private ArrayList <String> respuestas;
	private String correcta;
	
	public Pregunta() {
		super();
	}
	public Pregunta(String pregunta, ArrayList<String> respuestas, String correcta) {
		super();
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.correcta = correcta;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public ArrayList<String> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}
	public String getCorrecta() {
		return correcta;
	}
	public void setCorrecta(String correcta) {
		this.correcta = correcta;
	}
	
	
	
	
	
}
