package com.screv.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/teste")
public class Services {
	
	//Metodo Mostrar coordenadas adicionado pelo jonathan
	@Produces("application/json")
	@Consumes("application/json")
	@POST
	@Path("/mostrarCoord")
	public JSONObject mostrarCoord(JSONObject jsonParam){
		Double n1 = null;
		Double n2 = null;
		try{
			n1 = jsonParam.getDouble("latitude") ;
			n2 = jsonParam.getDouble("longitude") ;
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Double> hm = new HashMap<String, Double>() ;
		hm.put("coord1", n1) ;
		hm.put("coord2", n2) ;
		JSONObject resposta = new JSONObject(hm) ;
		return resposta ;
	}

	@Produces("application/json")
	@Consumes("application/json")
	@POST
	@Path("/somar")
	public JSONObject somar(JSONObject jsonParam) {

		// Lê os parâmetros em jsonParam e gera um outro JSON como resposta
		// Exemplo:
		Double n1 = null;
		Double n2 = null;
		try {
			n1 = jsonParam.getDouble("numero1");
			n2 = jsonParam.getDouble("numero2");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double soma = n1 + n2;

		HashMap<String, Double> hm = new HashMap<String, Double>();
		hm.put("resultado", soma);
		// Cada chave do HashMap vira uma Chave do JSON
		JSONObject resposta = new JSONObject(hm);
		return resposta;
	}
}