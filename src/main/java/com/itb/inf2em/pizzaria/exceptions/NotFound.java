package com.itb.inf2em.pizzaria.exceptions;


// extends : Herança, ocorre quando uma sub-classe "herda" características da super-classe, ou seja,
//           temos a classe mãe e a(s) classe(s) filha(s)
public class NotFound extends RuntimeException {

     // super: Acessando o construtor da classe mãe
     public NotFound(String message) {
           super(message);
     }


}
