package com.project.ReviewService.service.serviceImplim;

import com.project.ReviewService.Dto.ReviewDto;
import com.project.ReviewService.ReviewIntegration.Sender;
import com.project.ReviewService.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    Sender sender;
    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        sender.send(reviewDto);
        return reviewDto;
    }
}
