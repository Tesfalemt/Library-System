package com.project.BooksCommandService.Service.Dto;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BookDto {
    private long isbn;
    private String title;
    private String description;
    private String author;
}