package com.project.ReviewService.controller;

import com.project.ReviewService.Dto.ReviewDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody ReviewDto reviewDto){
        return null;
    }


    //to try
}
