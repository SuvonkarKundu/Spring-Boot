package com.crud.Repository;

import com.crud.model.Author;
import com.crud.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Suvonkar Kundu on 2/23/2019.
 */
public interface BookRepository extends PagingAndSortingRepository<Book,Long> {

    Book findById(long id);
    Book deleteById(long id);
}
