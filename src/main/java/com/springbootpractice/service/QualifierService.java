package com.springbootpractice.service;

import com.springbootpractice.components.ParentClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QualifierService {

    private final ParentClass parentClass;

    public QualifierService(@Qualifier("secondarySubclass") ParentClass parentClass) {
        this.parentClass = parentClass;
    }

    public String getPrimaryBean(){
        return parentClass.getPrimaryBean();
    }
}
