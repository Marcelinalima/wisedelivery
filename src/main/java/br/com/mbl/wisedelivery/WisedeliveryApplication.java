package br.com.mbl.wisedelivery;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mbl.wisedelivery.dominio.restaurante.CategoriaItem;
import br.com.mbl.wisedelivery.dominio.restaurante.Restaurante;
import br.com.mbl.wisedelivery.dominio.restaurante.RestauranteCategoria;
import br.com.mbl.wisedelivery.repository.CategoriaItemRepository;
import br.com.mbl.wisedelivery.repository.RestauranteCategoriaRepository;
import br.com.mbl.wisedelivery.repository.RestauranteRepository;
import br.com.mbl.wisedelivery.utils.ServiceUtils;



@SpringBootApplication
public class WisedeliveryApplication implements CommandLineRunner{

	@Autowired
	private RestauranteCategoriaRepository restauranteCategoriaRepository;

	@Autowired
	private CategoriaItemRepository categoriaItemRepository;
	
    @Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
    private ServiceUtils utils;
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

	   utils.consultaCep("88056750");

	   var catItem1 = CategoriaItem.builder()
			.nome("Bebidas")
			.imagem("null")
			.build();

		var catItem2 = CategoriaItem.builder()
			.nome("Refeicao")
			.imagem("null")
			.build();

		var catItem3 = CategoriaItem.builder()
			.nome("Sobremesas")
			.imagem("null")
			.build();
			
		var catItem4 = CategoriaItem.builder()
			.nome("Lanches")
			.imagem("null")
			.build();

		categoriaItemRepository.saveAll(List.of(catItem1, catItem2, catItem3, catItem4));
        
		Restaurante rest = new Restaurante();
		rest.setNome("Office Cafe");
		rest.setEmail("teste@teste.com");
		rest.setCnpj("111111111111");
		rest.setTelefone("21999999999");
		rest.setSenha("1234");
		rest.setCategorias(Set.of(cat1, cat2));

		restauranteRepository.save(rest);


		Restaurante rest1 = new Restaurante();
		rest.setNome("Restaurante Teste 1");
		rest.setEmail("teste@teste.com");
		rest.setCnpj("111111111111");
		rest.setTelefone("21999999999");
		rest.setSenha("1234");
		rest.setCategorias(Set.of(cat1, cat2, cat3, cat4));

		restauranteRepository.save(rest1);


	}

}