package br.com.mbl.wisedelivery.exception;

public class ObjetoNaoEncontradoException extends RuntimeException{

   
    private static String msg;

    public ObjetoNaoEncontradoException(String mString){
        super(msg);

    }
    
}