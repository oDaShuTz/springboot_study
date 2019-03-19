package org.springboot_study.properties;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Properties {

    @Value("${org.springboot_study.properties.name}")
    private String name;

    // lombok加载了getter和setter

}