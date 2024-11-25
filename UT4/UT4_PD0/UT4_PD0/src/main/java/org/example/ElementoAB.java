package org.example;

public class ElementoAB<T> implements IElementoAB {
    
    private ElementoAB<T> hijoIzq;
    private ElementoAB<T> hijoDer;
    private Comparable etiqueta;
    private T dato;
    
    public ElementoAB (Comparable etiqueta, T dato){
        this.etiqueta = etiqueta;
        this.dato = dato;
    }
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }
    
    /**
     *
     * @param unaEtiqueta
     * @return
     */
    @Override
    public ElementoAB buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) == 0){
            return this;
        } else {
            if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
                if (this.hijoIzq != null) {
                    return this.hijoIzq.buscar(unaEtiqueta);  
                }
                return null;
            } else {
                if (this.hijoDer != null) {
                    return this.hijoDer.buscar(unaEtiqueta);
                }
                return null;
            }
        }
    }

    @Override
    public boolean insertar(ElementoAB elemento) {
        if (elemento.getEtiqueta().compareTo(this.etiqueta) == 0){
            return false;
        }
        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0){
            if (this.hijoIzq == null){
                this.hijoIzq = elemento;
                return true;
            } else {
                this.hijoIzq.insertar(elemento);
            }
            return false;
        } else {
            if (this.hijoDer == null){
                this.hijoDer = elemento;
                return true;
            } else {
                this.hijoDer.insertar(elemento);
            }
            return false;
        }
    }

    @Override
    /* Preorden: Raiz -> Izquierdo -> Derecho */
    public String preOrden() {
        String tempStr = "";
        
        /* Checkeo raiz primero */
        tempStr += this.etiqueta;
        
        /* Despues checkeo hijo izquierdo */
        if (this.hijoIzq != null) {
            tempStr += this.hijoIzq.preOrden();
        }
        
        /* Despues checkeo hijo derecho */
        if (this.hijoDer != null) {
            tempStr += this.hijoDer.preOrden();
        }
        return tempStr;
    }

    @Override
    /* Inorden: Izquierdo -> Raiz -> Derecho */
    public String inOrden() {
        String tempStr = "";
        
        /* Checkeo hijo izquierdo primero */
        if (this.hijoIzq != null) {
            tempStr += this.hijoIzq.inOrden();
        }
        
        /* Despues checkeo raiz */
        tempStr += this.etiqueta;
        
        /* Despues checkeo hijo derecho */
        if (this.hijoDer != null) {
            tempStr += this.hijoDer.inOrden();
        }
        return tempStr;
    }

    @Override
    /* Postorden: Izquierdo -> Derecho -> Raiz */
    public String postOrden() {
        String tempStr = "";
        
        /* Checkeo hijo izquierdo primero */
        if (this.hijoIzq != null) {
            tempStr += this.hijoIzq.postOrden();
        }
        
        /* Despues checkeo hijo derecho */
        if (this.hijoDer != null) {
            tempStr += this.hijoDer.postOrden();
        }
        
        /* Despues checkeo raiz */
        tempStr += this.etiqueta;
        return tempStr;
    }

    @Override
    public Object getDatos() {
        return this.dato;
    }
    
    public boolean esVacio(){
        return !(hijoDer != null || hijoIzq != null);
    }
    private ElementoAB quitaElemento(){
        if (hijoIzq == null){
            return hijoDer;
        }
        if (hijoDer == null){
            return hijoIzq;
        }
        ElementoAB elHijo = hijoIzq;
        ElementoAB elPadre = this;
        while (elHijo.hijoDer != null){
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this){
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;
        return elHijo;
    }
    
    @Override
    public ElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) < 0){
            if (hijoIzq != null){
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(etiqueta) > 0){
            if (hijoDer != null){
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        System.out.println("Se eliminó el " + this.etiqueta + ".");
        return quitaElemento();
    }

    @Override
    public void setHijoIzq(ElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(ElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public ElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public ElementoAB getHijoDer() {
        return this.hijoDer;
    }

    public int calcularOperaciones() {
        
        if (hijoIzq != null){
            hijoIzq.calcularOperaciones();
        }
        if (hijoDer != null){
            hijoDer.calcularOperaciones();
        }
        if (hijoIzq != null && hijoDer != null){
            
            if (dato.equals("suma") || dato.equals("+") ) {
                suma();
            }else if (dato.equals("resta") || dato.equals("-")) {
                resta();
            }else if (dato.equals("multiplicacion") || dato.equals("*")) {
                mult();
            }else if (dato.equals("division") || dato.equals("/")){ 
                div();
            }
        }
        
        return (Integer) dato;
    }
  
    private void suma(){
        int a = 0;
        int b = 0;
        if (hijoIzq != null){
            if (hijoIzq.esHoja()){
                a = (Integer) hijoIzq.dato;
            }
        }
        if (hijoDer != null){
            if (hijoDer.esHoja()){
                b = (Integer) hijoDer.dato;
            }
        }
        Object operacion = (Integer) (a+b);
        hijoDer = null;
        hijoIzq = null;
        setDatos((T) operacion);
        //System.out.println( (a + b) +"suma");
    }

    private void resta() {
        int a = 0;
        int b = 0;
        if (hijoIzq != null){
            if (hijoIzq.esHoja())
                a = (Integer) hijoIzq.dato;
        }
        if (hijoDer != null){
            if (hijoDer.esHoja())
                b = (Integer) hijoDer.dato;
        }
        Object operacion = (Integer) (a-b);
        hijoDer = null;
        hijoIzq = null;
        setDatos((T) operacion);
        //System.out.println( (a - b) +"resta");
    }

    private void mult() {
        int a = 1;
        int b = 1;
        if (hijoIzq != null){
            if (hijoIzq.esHoja()){
                a = (Integer) hijoIzq.dato;
            }
        }
        if (hijoDer != null){
            if (hijoDer.esHoja()){
                b = (Integer) hijoDer.dato;
            }
        }
        //System.out.println(a*b +"mult");
        Object operacion = (Integer) (a*b);
        hijoDer = null;
        hijoIzq = null;
        setDatos((T) operacion);
    }

    private void div() {
        int a = 1;
        int b = 1;
        if (hijoIzq != null){
            if (hijoIzq.esHoja()){
                a = (Integer) hijoIzq.dato;
            }
        }
        if (hijoDer != null){
            if (hijoDer.esHoja()){
                if (!hijoDer.dato.equals(0) || !hijoDer.dato.equals("0"))
                    b = (Integer) hijoDer.dato;
            }
        }
        //System.out.println(a/b +"div");
        Object operacion = (Integer) (a/b);
        hijoDer = null;
        hijoIzq = null;
        setDatos((T) operacion);
    }
    private void setDatos(T data){
        dato = data;
    }
    private boolean esHoja(){
        return hijoIzq == null && hijoDer == null;
    }
    
    private void setEtiqueta(Comparable nuevaEtiqueta){
        etiqueta = nuevaEtiqueta;
    }
    
   
    public boolean insertarExpresion(String expresion){
        String op = "";
        //boolean pasa = false;
        String derecho = "";
        String izquierdo = "";
        int cont = 0;
        
        
        for (int i = 0; i < expresion.length(); i++){
            if (expresion.startsWith("(")){
                if (expresion.charAt(i) == '('){
                    cont++;
                }else if (expresion.charAt(i) == ')'){
                    cont--;
                }
                if (/*pasa == false &&*/ cont == 0  && esOperador(expresion.charAt(i))){
                    op = ""+expresion.charAt(i)+"";
                    setEtiqueta(op);
                    setDatos((T) op);   
                    //pasa = true;
                    izquierdo = expresion.substring(1,i);
                    derecho = expresion.substring(i+1);
                    break;
                }
                /*    
                //System.out.println("entro " + i);
                if (pasa == false && i > 0){
                    izquierdo = expresion.substring(1,i);
                    derecho = expresion.substring(i+2);
                    
                }*/
            } else if (!expresion.startsWith("(")){
            
                if (esOperador(expresion.charAt(i))){
                    op = ""+expresion.charAt(i)+"";
                    setEtiqueta(op);
                    setDatos((T) op);
                    //pasa = true;
                    izquierdo = expresion.substring(1,i);
                    derecho = expresion.substring(i+1);
                    break;
                }
                  /*  
                //System.out.println("entro " + i);
                if (pasa == false && i > 0){
                    System.out.println("entra");
                    System.out.println(derecho);
                    izquierdo = expresion.substring(1,i);
                    derecho = expresion.substring(i+2);
                }*/
            }
        }
        setEtiqueta(op);
        setDatos((T) op);
        setHijoIzq(new ElementoAB(izquierdo,izquierdo));
        setHijoDer(new ElementoAB(derecho, derecho));
         System.out.println("entro sigue");
        if (hijoIzq != null ){
            System.out.println("entro izqui" );
            this.hijoIzq.insertarExpresion(izquierdo);
        }else if (hijoIzq == null){
            System.out.println("entro izqui" );
            hijoIzq = new ElementoAB(izquierdo,izquierdo);
            
        }
        if (hijoDer != null ){
           System.out.println("entro der");
            this.hijoDer.insertarExpresion(derecho);
        }else{
            System.out.println("entro der");
            hijoDer = new ElementoAB(derecho,derecho);
           
        }
        
        
        return false;
    }
    
    
    private boolean esOperador(char caracter){
        return switch (caracter) {
            case '*' -> true;
            case '/' -> true;
            case '+' -> true;
            case '-' -> true;
            default -> false;
        };
    }
 
    public static String quitaParentisis(String exp){
        if (exp.startsWith("(") && exp.endsWith(")")){
            System.out.println("entro quita parent");
            return exp.substring(1, exp.length()-1);
        }
        return exp;
    }
}
    /*

*/

            