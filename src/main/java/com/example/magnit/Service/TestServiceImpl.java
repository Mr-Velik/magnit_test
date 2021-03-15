package com.example.magnit.Service;

import com.example.magnit.Model.Test;
import com.example.magnit.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;

    @Autowired
    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public void addAll(int n) {
        List<Test> listTest = new ArrayList<>(n);

        for(long i = 1; i <= n; i++) {
            listTest.add(new Test(i));
        }
        testRepository.saveAll(listTest);
    }
}
