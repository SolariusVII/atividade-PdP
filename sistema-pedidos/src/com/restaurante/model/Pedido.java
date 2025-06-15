package com.restaurante.model;

public class Pedido {
    private int id;
    private String cliente;
    private String item;
    private double valor;
    private String status;
    
    public Pedido(int id, String cliente, String item, double valor, String status) {
        this.id = id;
        this.cliente = cliente;
        this.item = item;
        this.valor = valor;
        this.status = status;
    }
    
    // Getters
    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public String getItem() { return item; }
    public double getValor() { return valor; }
    public String getStatus() { return status; }
    
    // Setters
    public void setId(int id) { this.id = id; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setItem(String item) { this.item = item; }
    public void setValor(double valor) { this.valor = valor; }
    public void setStatus(String status) { this.status = status; }
}