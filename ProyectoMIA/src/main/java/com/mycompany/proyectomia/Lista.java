/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import com.mycompany.proyectomia.Nodo;

/**
 *
 * @author landivar
 */
public class Lista {

    private Integer tam;
    private Nodo inicio;
    private Nodo recorredor;

    public Lista() {
        tam = 0;
        inicio = null;
    }

    public Integer Tama() {
        return tam;
    }

    public Boolean esVacia() {
        return tam == 0;
    }
    public void inicio(Nodo cambio)
    {
        this.inicio=cambio;
    }
    public void Insertar(Cancion cancion) {
        if (esVacia()) {
            Nodo nuevo = new Nodo();
            nuevo.setCancion(cancion);
            nuevo.setSiguiente(null);
            nuevo.setAnterior(null);
            inicio = nuevo;
            tam++;
        } else {
            Nodo nuevo = new Nodo();
            nuevo.setCancion(cancion);
            inicio.setAnterior(nuevo);
            nuevo.setSiguiente(inicio);
            nuevo.setAnterior(null);
            inicio = nuevo;
            tam++;
        }
    }

    public void Mostrar(Nodo inicio) {
        while (inicio.getSiguiente() != null) {
            System.out.println(inicio.getCancion().getUrl());
            inicio = inicio.getSiguiente();
        }
        /*while(inicio!=null)
        {
            System.out.println(inicio.getCancion().getUrl());
            inicio=inicio.getAnterior();
        }*/
    }

    public Nodo frente() {
        return inicio;
    }

    public Nodo actual() {
        return recorredor;
    }

    public void setActual(Nodo nuevoActual) {
        recorredor = nuevoActual;
    }

    public Nodo NodoAux(Nodo prin) {
        recorredor = prin;
        recorredor.setSiguiente(prin.getSiguiente());
        return recorredor;
    }

    public Nodo Anterior() {
        if (recorredor.getAnterior() != null) {
            recorredor = recorredor.getAnterior();
        }
        return recorredor;
    }

    public Nodo Siguiente() {
        if (recorredor.getSiguiente() != null) {
            recorredor = recorredor.getSiguiente();
        }
        return recorredor;
    }

    public Nodo pop(Nodo nodo, Nodo inicio) {
        if(inicio==null)
        {
            return null;
        }
        else if(tam==1)
        {
            inicio=null;
            tam--;
            return inicio;
        }
        else if(nodo==this.inicio)
        {
            nodo=nodo.getSiguiente();
            nodo.setAnterior(null);
            tam--;
            return nodo;
        }
       
        else
        {
            if(inicio.getCancion()==nodo.getCancion())
            {
                
            Nodo aux=inicio.getAnterior();
            aux.setSiguiente(inicio.getSiguiente());
            tam--;     
            return aux;   
            }
            else
            {
                inicio.setSiguiente(pop(nodo, inicio.getSiguiente()));
                return inicio;
            }
        }
    }

    public void setRecorredor() {
        this.recorredor = this.inicio;
    }
}
