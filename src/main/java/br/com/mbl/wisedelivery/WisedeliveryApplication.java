package br.com.mbl.wisedelivery;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mbl.wisedelivery.dominio.restaurante.CategoriaItem;
import br.com.mbl.wisedelivery.dominio.restaurante.ItemCardapio;
import br.com.mbl.wisedelivery.dominio.restaurante.Restaurante;
import br.com.mbl.wisedelivery.dominio.restaurante.RestauranteCategoria;
import br.com.mbl.wisedelivery.repository.CategoriaItemRepository;
import br.com.mbl.wisedelivery.repository.ItemCardapioRepository;
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
	private ItemCardapioRepository itemCardapioRepository;

	@Autowired
    private ServiceUtils utils;

	
	public static void main(String[] args) {
		SpringApplication.run(WisedeliveryApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
        var cat1 = RestauranteCategoria.builder()
				.nome("Churrasco")
				.build();
				
	    var cat2 = RestauranteCategoria.builder()
				.nome("Massas")
				.build();

	    var  cat3 = RestauranteCategoria.builder()
				.nome("Ásiatica")
				.build();

	    var  cat4 = RestauranteCategoria.builder()
				.nome("Mediterraneo")
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
        

		Restaurante rest2 = new Restaurante();
		rest2.setNome("Tia Maluca");
		rest2.setEmail("tiamaluca@rest.com");
		rest2.setCnpj("111111111111");
		rest2.setTelefone("21999999999");
		rest2.setSenha("1234");

		rest2.setCategorias(Set.of(cat3, cat4));

		restauranteRepository.saveAll(List.of(rest, rest2));
        

       criarESalvarItemDeCardapio(rest, List.of(catItem1, catItem2));
	   criarESalvarItemDeCardapio(rest2, List.of(catItem3, catItem4));

	}
	private void criarESalvarItemDeCardapio(Restaurante restaurante, List<CategoriaItem> categorias) {
	
	
		var item1 = ItemCardapio.builder()
					.nome("Batata Maluca")
					.descricao("Batata frita com queijo")
					.preco(BigDecimal.valueOf(25.0))
					.destaque(Boolean.TRUE)
					.restaurante(restaurante)
					.categorias(categorias)
					.build();
              
		var item2 = ItemCardapio.builder()
					.nome("Duplo x Burguer")
					.descricao("Hamburguer com  salada extra")
					.preco(BigDecimal.valueOf(20.0))
					.destaque(Boolean.TRUE)
					.restaurante(restaurante)
					.categorias(categorias)
					.build();

        
		var item3 = ItemCardapio.builder()
					.nome("Dogão Foods")
					.descricao("Cachorro quente com pure de batata e batata palha")
					.preco(BigDecimal.valueOf(30.0))
					.destaque(Boolean.FALSE)
					.restaurante(restaurante)
					.categorias(categorias)
					.build();

		
					
		var item4 = ItemCardapio.builder()
					.nome("Salgado Frito")
					.descricao("Variedades de salgado frito na hora")
					.preco(BigDecimal.valueOf(7.0))
					.destaque(Boolean.FALSE)
					.restaurante(restaurante)
					.categorias(categorias)
					.build();
	
		itemCardapioRepository.saveAll(List.of(item1, item2, item3, item4));
	}	

}

