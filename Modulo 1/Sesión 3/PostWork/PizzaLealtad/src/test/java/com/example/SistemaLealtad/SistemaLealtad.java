package com.example.SistemaLealtad;

public class SistemaLealtad {

    private boolean estatusTajeta;
    private int saldoPuntos;
    private boolean estatusCupon;

    public SistemaLealtad() {
        setEstatusCupon(true);
    }

    public boolean getEstatusTarjeta() {
        return this.estatusTajeta;
    }

    public void setEstatusTarjeta(boolean estatusTarjeta) {
        this.estatusTajeta = estatusTarjeta;
    }

    public int getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(int saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public boolean getEstatusCupon() {
        return estatusCupon;
    }

    public void setEstatusCupon(boolean estatusCupon) {
        this.estatusCupon = estatusCupon;
    }

    public String mostrarProductosExtras() {
        return regresaProducto();
    }

    public void usarCupon(String respuesta) {
        if (respuesta.equals("Y"))
            setEstatusCupon(false);
    }

    private String regresaProducto() {
        String productoExtra = "";
        int puntos = getSaldoPuntos();
        if (puntos >= 50 && puntos <= 100)
            productoExtra = "Espagueti";
        else if (puntos > 100 && puntos <= 150)
            productoExtra = "Espagueti,Queso Extra";
        else if (puntos > 150)
            productoExtra = "Espagueti,Queso Extra,Cupon Pizza Gratis";
        return productoExtra;
    }

}
