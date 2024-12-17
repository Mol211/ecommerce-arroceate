package com.mol21.arroceatE_commerce.__arroceate.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefono;

    @ManyToMany
    @JoinTable(
            name = "cliente_direccion", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "cliente_id"), // FK hacia Cliente
            inverseJoinColumns = @JoinColumn(name = "direccion_id") // FK hacia DirecEnvio
    )
    private Set<DirecEnvio> direccionesCliente = new HashSet<>();
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pedido> pedidos = new HashSet<>();

    @OneToOne(mappedBy = "cliente")  // Relación inversa a Usuario
    private Usuario usuario;  // Relación uno a uno con Usuario

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<DirecEnvio> getDireccionesCliente() {
        return direccionesCliente;
    }

    public void setDireccionesCliente(Set<DirecEnvio> direccionesCliente) {
        this.direccionesCliente = direccionesCliente;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
