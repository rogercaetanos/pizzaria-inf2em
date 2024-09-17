package com.itb.inf2em.pizzaria;


import com.itb.inf2em.pizzaria.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzariaApplication.class, args);
		System.out.println("Meu primeiro projeto Spring Boot");

		Produto p1 = new Produto();
		//p1.precoVenda = -56.00; // acesso direto ao atributo atribuindo valor inválido!  agora o acesso não é mais permitido
        p1.setPrecoVenda(45.00);

		System.out.println("Preço de venda: R$ " + p1.getPrecoVenda());




	}

}
