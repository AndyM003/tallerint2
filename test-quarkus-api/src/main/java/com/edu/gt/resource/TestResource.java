/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.gt.resource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Optional;

/**
 *
 * @author wcordova
 */
@Path("/HolaMundo")
public class TestResource {
    
     @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String holaMundo(){
        return "Hola mundo";        
    }
    
    @GET
    @Path("/saludar")
    @Produces(MediaType.TEXT_PLAIN)
    public String saludar(@QueryParam("mensaje") String mensaje){
        return Optional.ofNullable(mensaje)
                .map(n -> " > " + n)
                .orElse("No se que decir");        
        /**
        if(mensaje != null && !mensaje.isEmpty()){
            return mensaje;
        }        else{
            return "no se que decir";
        }**/
    }
    
    @GET
    @Path("/prueba")
    @Produces(MediaType.TEXT_PLAIN)
    public String prueba() {
        String json = "{\"name\":\"John Doe\"}";

        ObjectMapper mapper = new ObjectMapper();
        try {
            //mapper.configure(DeserializationFeature., true);
            JsonNode node = mapper.readTree(json);

            Object object = mapper.convertValue(node, Object.class);
            System.out.println("node: " + object);
            Object data = mapper.readValue(json, Object.class);
            System.out.println(data);
        } catch (Exception e) {
            throw new RuntimeException("Unable to convert object. " + e.getMessage(), e);
        }

        return "Hola mundo";
    }

}
