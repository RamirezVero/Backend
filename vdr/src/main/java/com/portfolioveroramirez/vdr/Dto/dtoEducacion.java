
package com.portfolioveroramirez.vdr.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank    
    private String institucion;
    @NotBlank
    private String conocimientos;
    private String inicio;
    private String fin;

    public dtoEducacion() {
    }

    public dtoEducacion(String titulo, String institucion, String conocimientos, String inicio, String fin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.conocimientos = conocimientos;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(String conocimientos) {
        this.conocimientos = conocimientos;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    
    
}
