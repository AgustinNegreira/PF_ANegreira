package org.example;

public class Alumno{
    private int ID;
    private String fullName;
    private String email;
    
    public Alumno(int ID, String name, String email){
        this.ID = ID;
        this.fullName = name;
        this.email = email;
    }
    
    public boolean equals(Alumno alumno){
        return (alumno.ID == this.ID && alumno.fullName == this.fullName && alumno.email == this.email);
    }
    
    public int hashCode(){
        int hash = 0;
        int id = ID;
        String name = fullName;
        String mail = email;
        hash = name.hashCode() + mail.hashCode() + id;
        return hash;
    }
}