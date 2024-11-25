package org.example;

import java.util.LinkedList;

public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    public TNodoTrieTelefonos getRaiz() {
        return raiz;
    }

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList abonados = new LinkedList();
        String primerosDigitos = pais + area;
        if (raiz == null)
            return abonados;
        else
            raiz.buscarTelefonos(primerosDigitos, abonados);
        return abonados;    }

    @Override
    public void insertar(TAbonado abonado) {
        if(raiz == null){
            raiz = new TNodoTrieTelefonos();
        }else{
            raiz.insertar(abonado);
        }
        
    }
}