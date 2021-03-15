package com.example.magnit.Repository;

import com.example.magnit.Model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {
   List<Test> findAll();
}
