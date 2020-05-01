package com.example.tallerfinal_firebase;

public class Notas {

    private String idUnico;
    private String codMatricula;
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    private String promedioNotas;

    public Notas(String idUnico, String codMatricula, String nombre, String promedioNotas){
        this.idUnico = idUnico;
        this.codMatricula = codMatricula;
        this.nombre = nombre;
        this.promedioNotas = promedioNotas;

    }

    public Notas() {

    }

    public String getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(String idUnico) {
        this.idUnico = idUnico;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public String getPromedioNotas() {
        return promedioNotas;
    }

    public void setPromedioNotas(String promedioNotas) {
        this.promedioNotas = promedioNotas;
    }

    public double promedioNotas(){
        return( (this.getNota1()+this.getNota2()+this.getNota3()) / 3);
    }
}
