
package com.briefcase.briefcase.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    private String nameRecource;
    private String name;
    private long valueName;
    
    public ResourceNotFoundException(String nameRecource, String name, long valueName) {
		super(String.format("%s no encontrada con : %s : '%s'", nameRecource, name, valueName));
		this.nameRecource = nameRecource;
		this.name = name;
		this.valueName = valueName;
	}

	public String getNombreDelRecurso() {
		return nameRecource;
	}

	public void setNombreDelRecurso(String nameRecource) {
		this.nameRecource = nameRecource;
	}

	public String getNombreDelCampo() {
		return name;
	}

	public void setNombreDelCampo(String name) {
		this.name = name;
	}

	public long getValorDelCampo() {
		return valueName;
	}

	public void setValorDelCampo(long valueName) {
		this.valueName = valueName;
	}
}
