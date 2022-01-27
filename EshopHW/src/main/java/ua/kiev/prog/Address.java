package ua.kiev.prog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String country;
    private String city;
    private String street;

    @OneToOne(mappedBy = "address")
    private Client client;

    public Address(String country, String city, String street){
        this.country = country;
        this.city = city;
        this.street = street;
    }

}
