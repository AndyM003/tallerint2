/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.gt.resource;

import com.edu.gt.dto.Temperatura;
import com.edu.gt.service.impl.TemperaturaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author wcordova
 */
@Path("/temperaturas")
public class TemperaturasResource {
    
    @Inject
    private TemperaturaService temperaturas;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura medicion(){
        return new Temperatura("Guatemala", 25, 32);
    }
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> list(){        
        return temperaturas.obtenerTemperaturas();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura guardar(Temperatura temp){  
        System.out.println("Init guardar");
        temperaturas.addTemperatura(temp);
        return temp;
    }
    
    @GET
    @Path("/maxima")
    @Produces(MediaType.TEXT_PLAIN)
    public Response maxima (){        
        if (temperaturas.isEmpty()) 
            return Response.status(401).entity("No hay temperaturas").build();
   
        int temperaturaMaxima = temperaturas.maxima();
        return Response.ok(Integer.toString(temperaturaMaxima)).build();
    }
    
    /**
     * Tarea crear el delete
     */
    
    
    
}
