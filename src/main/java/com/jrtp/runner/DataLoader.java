package com.jrtp.runner;

import com.jrtp.entity.CitizenPlansInfoEntity;
import com.jrtp.repository.CitizenPlansInfoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private CitizenPlansInfoEntityRepository crepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Random rand=new Random();
        //CashPlan
        CitizenPlansInfoEntity c1=new CitizenPlansInfoEntity();
        c1.setCitizenName("Amit");
        c1.setGender("Male");
        c1.setPlanName("Cash");
        c1.setPlanStatus("Approved");
        c1.setPlanStartDate(LocalDate.now());
        c1.setPlanEndDate(LocalDate.now().plusDays(12));
        c1.setBenifitAmount(5000l);

        CitizenPlansInfoEntity c2=new CitizenPlansInfoEntity();
        c2.setCitizenName("Sumit");
        c2.setGender("Male");
        c2.setPlanName("Cash");
        c2.setPlanStatus("Denied");
        c2.setDenialReason("Rental Income");
        c2.setDenialReason("Rental Income is not Valid");
        c2.setBenifitAmount(0l);

        CitizenPlansInfoEntity c3=new CitizenPlansInfoEntity();
        c3.setCitizenName("Manjit");
        c3.setGender("Fe-Male");
        c3.setPlanName("Cash");
        c3.setPlanStatus("Terminated");
        c3.setTerminationReason("No Income");
        


        //foodPlans
        CitizenPlansInfoEntity c4=new CitizenPlansInfoEntity();
        c4.setCitizenName("Durgesh");
        c4.setGender("Male");
        c4.setPlanName("Food");
        c4.setPlanStatus("Approved");
        c4.setPlanStartDate(LocalDate.now().minusDays(130));
        c4.setPlanEndDate(LocalDate.now().plusDays(120));
        c4.setBenifitAmount(10000l);

        CitizenPlansInfoEntity c5=new CitizenPlansInfoEntity();
        c5.setCitizenName("John");
        c5.setGender("Male");
        c5.setPlanName("Food");
        c5.setPlanStatus("Denied");
        c5.setDenialReason("Lower Income");
        c5.setBenifitAmount(0l);

        CitizenPlansInfoEntity c6=new CitizenPlansInfoEntity();
        c6.setCitizenName("Soniya");
        c6.setGender("Fe-Male");
        c6.setPlanName("Food");
        c6.setPlanStatus("Approved");
        c6.setPlanStartDate(LocalDate.ofEpochDay(20));
        c6.setPlanEndDate(LocalDate.now().plusDays(1000));
        c6.setBenifitAmount(20000l);


        // EmployementPlan
        CitizenPlansInfoEntity c7 = new CitizenPlansInfoEntity();
        c7.setCitizenName("Ravi");
        c7.setGender(rand.nextBoolean() ? "Male" : "Fe-Male");
        c7.setPlanName("Employee");
        c7.setPlanStatus("Approved");
        c7.setPlanStartDate(LocalDate.now().minusDays(rand.nextInt(30)));
        c7.setPlanEndDate(LocalDate.now().plusDays(7 + rand.nextInt(30)));
        c7.setBenifitAmount(rand.nextLong(10000));

        CitizenPlansInfoEntity c8 = new CitizenPlansInfoEntity();
        c8.setCitizenName("Nisha");
        c8.setGender("Fe-Male");
        c8.setPlanName("Employee");
        c8.setPlanStatus("Denied");
        c8.setDenialReason("Income too high");
        c8.setBenifitAmount(0L);

        CitizenPlansInfoEntity c9 = new CitizenPlansInfoEntity();
        c9.setCitizenName("Ajay");
        c9.setGender("Male");
        c9.setPlanName("Employee");
        c9.setPlanStatus("Terminated");
        c9.setTerminationReason("Exceeded eligibility");
        c9.setBenifitAmount(0L);

        // FarmerPlans
        CitizenPlansInfoEntity c10 = new CitizenPlansInfoEntity();
        c10.setCitizenName("Priya");
        c10.setGender("Female");
        c10.setPlanName("Farmer");
        c10.setPlanStatus("Approved");
        c10.setPlanStartDate(LocalDate.now().minusDays(100 + rand.nextInt(30)));
        c10.setPlanEndDate(LocalDate.now().plusDays(60 + rand.nextInt(60)));
        c10.setBenifitAmount(rand.nextLong(20000));

        CitizenPlansInfoEntity c11 = new CitizenPlansInfoEntity();
        c11.setCitizenName("Raj");
        c11.setGender("Male");
        c11.setPlanName("Farmer");
        c11.setPlanStatus("Denied");
        c11.setDenialReason("Too high income");
        c11.setBenifitAmount(0L);

        CitizenPlansInfoEntity c12 = new CitizenPlansInfoEntity();
        c12.setCitizenName("Meera");
        c12.setGender("Fe-Male");
        c12.setPlanName("Farmer");
        c12.setPlanStatus("Approved");
        c12.setPlanStartDate(LocalDate.of(2020, 1, 1).plusDays(rand.nextInt(1000)));
        c12.setPlanEndDate(LocalDate.now().plusDays(500 + rand.nextInt(500)));
        c12.setBenifitAmount(rand.nextLong(30000));

        List<CitizenPlansInfoEntity> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
//        crepo.saveAll(list);
    }
}
