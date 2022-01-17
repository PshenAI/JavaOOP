package ua.kiev.prog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "goods")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String price;

    @ManyToMany(mappedBy = "goods")
    private Set<Order> orders = new HashSet<>();


    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id - " + (id-1) + "{ " + name + " goes by price " + price + " }";
    }
}
