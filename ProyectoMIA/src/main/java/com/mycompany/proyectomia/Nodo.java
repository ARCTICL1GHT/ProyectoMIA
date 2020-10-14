/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;
/**
 *
 * @author landivar
 */
public class Nodo {
    private Nodo siguiente;
    private Nodo anterior;
    private Cancion cancion;
    
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente=siguiente;        
    }
    public Nodo getSiguiente()
    {
        return siguiente;
    }
    public void setAnterior(Nodo anterior)
    {
        this.anterior=anterior;
    }
    public Nodo getAnterior()
    {
        return anterior;
    }
    public void setCancion(Cancion cancion)
    {
        this.cancion=cancion;
    }
    public Cancion getCancion()
    {
        return cancion;
    }
    
}
