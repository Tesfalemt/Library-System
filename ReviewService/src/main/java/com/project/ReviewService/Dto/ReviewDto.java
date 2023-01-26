package com.project.ReviewService.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

 private String description;
 private String isbn;
 private Integer rating;
 private long customerNumber;

}
