package com.project.BorrowingsService.service.Dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BorrowingsDto {
    private List<BorrowingDto> borrowingsDTO;
}
