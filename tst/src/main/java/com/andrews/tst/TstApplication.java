package com.andrews.tst;

import com.andrews.tst.entity.EntityPackageMarker;
import com.andrews.tst.repository.RepositoryPackageMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {EntityPackageMarker.class, RepositoryPackageMarker.class})
public class TstApplication {
    public static void main(String[] args) {
        SpringApplication.run(TstApplication.class, args);
    }
}