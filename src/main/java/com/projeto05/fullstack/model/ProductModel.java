package com.projeto05.fullstack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String name;
    private String mark;


}
