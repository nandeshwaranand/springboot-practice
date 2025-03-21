package com.springbootpractice.controller;

import com.springbootpractice.service.PrimaryService;
import com.springbootpractice.service.QualifierService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ambiguity")
@CrossOrigin(origins = "*")
public class PracticeController {

    private final PrimaryService primaryService;

    private final QualifierService qualifierService;

    public PracticeController(PrimaryService primaryService, QualifierService qualifierService) {
        this.primaryService = primaryService;
        this.qualifierService = qualifierService;
    }

    @GetMapping("/default-bean")
    public String getDefaultBean(){
        return primaryService.getPrimaryBean();
    }

    @GetMapping("/qualifier-bean")
    public String getQualifierBean(){
        return qualifierService.getPrimaryBean();
    }
}
