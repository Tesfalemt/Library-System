package com.project.BorrowingsService.service.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BookDto {

    private long isbn;
    private String title;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String author;

}
