package com.sekcja3.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class StudentsApplication {

	@Autowired
	private CarProperties carProperties;

	@Bean // metoda jest wywoływana bo ma adnotację @Bean wiec jak wstaje Spring to jest on wykonywana
	public void showCarProperties(){
		System.out.println(carProperties.getMark() + " " + carProperties.getModel());
	}


	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);


		//przykład z optionalem
		Optional<String> notEmptyOptional = Optional.of("Wartość");

//		notEmptyOptional.orElse(showText()); 			// wywołuje się zawsze
//		notEmptyOptional.orElseGet(() ->showText2());   // wywołuje się tylko gdy optional pusty


	}

//	public static String showText(){
//		System.out.println("");
//		System.out.println("Metoda się wywołała");
//		return "Oczekuję, aby zwrócić string ";
//	}
//
//	public static String showText2(){
//		System.out.println("");
//		System.out.println("Metoda się wywołała 22222222");
//		return "Oczekuję, aby zwrócić string 2222222222 ";
//	}

}
