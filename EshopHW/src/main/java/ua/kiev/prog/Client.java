package ua.kiev.prog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String number;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        if(!orders.contains(order)){
            orders.add(order);
            order.setClient(this);
        }
    }

    public Client(String name, String number){
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", address=" + address +
                '}';
    }
}
