package com.JavaTechieSpring.batching;

import org.springframework.batch.item.ItemProcessor;

public class CSVProcessor implements ItemProcessor<CSVBean,CSVBean> {

    @Override
    public CSVBean process(CSVBean item) throws Exception {
         return  item;
    }
}
