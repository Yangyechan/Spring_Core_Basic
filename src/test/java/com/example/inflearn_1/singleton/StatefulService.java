package com.example.inflearn_1.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulService {

    // private int price; //상태를 유지하는 필드
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
//    }
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }
//    public int getPrice() {
//        return price;
//    }
}
