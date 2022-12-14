package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Commande",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id")
    private Long id;
    @Column(nullable = false,unique = true)
    private String ref;
    @Column(nullable = false)
    private LocalDate date;
    private Double prixTotal;
    // collum for the enum status
    @Column(nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    //@JsonManagedReference
    private Client client;

    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    //@JsonBackReference
    private List<CommandeItem> commandeItems;
    @PrePersist
    public void generateReference() {
        byte [] bytes = new byte[4];
        this.ref = UUID.nameUUIDFromBytes(bytes).toString();
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", date=" + date +
                ", prixTotal=" + prixTotal +
                ", status='" + status + '\'' +
                '}';
    }
}