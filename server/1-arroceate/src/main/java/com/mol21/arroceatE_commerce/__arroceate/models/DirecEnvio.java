package com.mol21.arroceatE_commerce.__arroceate.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DirecEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String calleYNumero;
    private String numero;

    @Column()
    private String puerta;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String codPostal;

    @Column()
    private String observaciones;

    @Column(nullable = false)
    private LocalDateTime fechaReg;
    private boolean esDirecPrincipal;

    @ManyToMany(mappedBy = "direccionesCliente")
    private Set<Cliente> clientes = new HashSet<>();

    public DirecEnvio() {
        this.fechaReg = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getCalleYNumero() {
        return calleYNumero;
    }

    public void setCalleYNumero(String calleYNumero) {
        this.calleYNumero = calleYNumero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaReg() {
        return fechaReg;
    }

    public boolean isEsDirecPrincipal() {
        return esDirecPrincipal;
    }

    public void setEsDirecPrincipal(boolean esDirecPrincipal) {
        this.esDirecPrincipal = esDirecPrincipal;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
}
