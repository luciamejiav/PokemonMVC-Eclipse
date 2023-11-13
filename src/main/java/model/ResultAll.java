package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResultAll {
	@SerializedName("results") //resuts tiene un listado de pokemon asi que le cambiamos el nombre
	private List<Pokemon> pokemons;

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	@Override
	public String toString() {
		return "ResultAll [pokemons=" + pokemons + "]";
	}
	
	

}
