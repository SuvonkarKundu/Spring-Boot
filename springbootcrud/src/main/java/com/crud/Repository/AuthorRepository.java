package com.crud.Repository;

import com.crud.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Suvonkar Kundu on 2/23/2019.
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {
    Author findById(long id);
    Author deleteById(long id);
}
