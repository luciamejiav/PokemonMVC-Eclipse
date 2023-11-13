package view;

import manejador.Manejador;
import model.Pokemon;
import model.ResultAll;

public class Prueba {

	public static void main(String[] args) {
		Manejador manejador = new Manejador("https://pokeapi.co/api/v2/pokemon-species?limit=1017");
		ResultAll result = manejador.getResult();
		
		String foto = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
		
		for(Pokemon pokemon: result.getPokemons()) {
			String[] trozosFoto = pokemon.getUrl().split("/");
			foto += trozosFoto[trozosFoto.length-1] + ".png";
			pokemon.setFoto(foto);
			System.out.println(pokemon);
		}
	}

}
