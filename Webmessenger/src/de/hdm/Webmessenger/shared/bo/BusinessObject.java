package de.hdm.Webmessenger.shared.bo;

import java.io.Serializable;
import java.util.Date;

/*
 * Alle Business Objects weisen gemeinsame Attribute und Methoden auf.
 * Zur Aufwandsverringerung dient diese abstrakte Klassen von der die
 * jeweiligen Attribute und Methoden geerbt werden.
 *
 */
public abstract class BusinessObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/* 
	 * Dient zur Identifikation
	 * der Instanz eines Business Objects. 
	 */
	
	private int id = 0;
	private Date erstellungsZeitpunkt = new Date();
	
	
	/*
	 * Getter und Setter Methoden
	 */
	public void setId(int i) {
		this.id = i;
	}
	
	public int getId() {
		return this.id;
	}
	
	public long getDate() {
		return this.erstellungsZeitpunkt.getTime();
	}
	
	public boolean equals (Object o) {
		if (o != null && o instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject) o;
			try {
				if(bo.getId() == this.id) 
					return true;
			}
				catch (IllegalArgumentException e) {
					return false;
				}
			}
			return false;
		}
	
	public int hashCode() {
		return this.id;
	}
}
	

