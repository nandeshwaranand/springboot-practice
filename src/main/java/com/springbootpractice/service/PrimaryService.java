package com.springbootpractice.service;

import com.springbootpractice.components.ParentClass;
import org.springframework.stereotype.Service;

@Service
public class PrimaryService {

    private final ParentClass parentClass;

    public PrimaryService(ParentClass parentClass) {
        this.parentClass = parentClass;
    }

    public String getPrimaryBean(){
      return parentClass.getPrimaryBean();
    }
}
