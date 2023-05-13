package br.com.mbl.wisedelivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mbl.wisedelivery.dominio.RestauranteCategoria;
import br.com.mbl.wisedelivery.repository.RestauranteCategoriaRepository;
import br.com.mbl.wisedelivery.service.impl.ImageServiceImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class WisedeliveryApplication implements CommandLineRunner{

	@Autowired
	private RestauranteCategoriaRepository restauranteCategoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(WisedeliveryApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
      RestauranteCategoria cat1 = RestauranteCategoria.builder()
	  .nome("Churrasco")
	  .build();
	  
	   RestauranteCategoria cat2 = RestauranteCategoria.builder()
	   .nome("Massas")
	   .build();

	   RestauranteCategoria cat3 = RestauranteCategoria.builder()
	   .nome("Ásiatica")
	   .build();

	   RestauranteCategoria cat4 = RestauranteCategoria.builder()
	   .nome("Lanches")
	   .build();

	   restauranteCategoriaRepository.saveAll(List.of(cat1, cat2, cat3, cat4));

	   log.info(ImageServiceImpl.criarPastaDeUpload());

	}

}