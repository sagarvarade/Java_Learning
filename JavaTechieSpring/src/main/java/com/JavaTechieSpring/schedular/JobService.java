package com.JavaTechieSpring.schedular;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@EnableScheduling
public class JobService {

    //@Scheduled(fixedRate = 5_000)  //Every 5 second
    @Scheduled(cron = "30 * * * * ?") // with cron every minute
    public  void printMe(){
        LocalDateTime local=LocalDateTime.now();
        System.out.println(" Printing : "+local.toString());
    }
}
