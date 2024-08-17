package com.JavaTechieSpring.batching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CSVService {

    @Autowired
    private CSVRepository csvRepository;

}
