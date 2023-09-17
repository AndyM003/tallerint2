/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.gt.dto;

import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author wcordova
 */
@Data
public class BookDto {

    private Long id;
    private String title;
    private int numPages;
    private LocalDate pubDate;
    private String description;
    
    

}
