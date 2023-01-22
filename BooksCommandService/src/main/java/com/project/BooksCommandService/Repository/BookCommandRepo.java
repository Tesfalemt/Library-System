package com.project.BooksCommandService.Repository;

import com.project.BooksCommandService.Domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCommandRepo extends MongoRepository <Book,Long>{

}
