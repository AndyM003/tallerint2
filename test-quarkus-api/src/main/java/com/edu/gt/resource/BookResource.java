/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.gt.resource;

import com.edu.gt.dto.BookDto;
import com.edu.gt.model.Book;
import com.edu.gt.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author wcordova
 */
@Path("/book")
public class BookResource {

    @Inject
    private BookRepository repo;

    @GET
    public List<Book> index() {
        return repo.listAll();
    }

    @POST
    public Response insert(BookDto b) {
        System.out.println("Ingresa nuevo libro: " + b);
        try {
            Book book = convertoToDo(b);
            repo.persist(book);
            System.out.println("Nuevo libro creado exitosamente");
            return Response.ok(b).build();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Response.status(400).build();
        }

    }

    public Book convertoToDo(BookDto b) {
        Book book = new Book();
        book.setTitle(b.getTitle());
        book.setNumPages(b.getNumPages());
        book.setPubDate(b.getPubDate());
        book.setDescription(b.getDescription());

        return book;

    }
    
    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") Long id) {
        System.out.println("Consultando id: " + id);
        var book = repo.findById(id);
        if (book != null) {
            System.out.println("Exito valor: " + book);
            return Response.ok(book).build();
        }else{
            System.out.println("El valor: " + id + " no fue encontrado");
            return Response.status(400).entity("No existe ID").build();
        }
    }

}
