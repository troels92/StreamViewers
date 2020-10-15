package com.stream.ts.repository;

import com.stream.ts.model.Stream;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends CrudRepository<Stream, Long> {

}
