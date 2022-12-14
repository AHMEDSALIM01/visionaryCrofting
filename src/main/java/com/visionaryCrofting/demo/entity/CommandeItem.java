package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "CommandeItem",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class CommandeItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ref" , nullable = false,unique = true)
    private String ref;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;
    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "commande_id")
    //@JsonManagedReference
    private Commande commande;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "product_id")
    //@JsonBackReference
    private Product product;

    @Override
    public String toString() {
        return "CommandeItem{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", product=" + product +
                '}';
    }
}
