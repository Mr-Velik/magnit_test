package com.example.magnit.Service;

import com.example.magnit.Model.Test;

import java.util.List;

public interface TestService {
   List<Test> findAll();
   void addAll(int n);
}
