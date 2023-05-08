package br.com.mbl.wisedelivery.controller.validator;

public interface Validator<T> {

    boolean validator( T t);
    
}