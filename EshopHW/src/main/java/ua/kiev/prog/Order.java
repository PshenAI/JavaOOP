package ua.kiev.prog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> goods = new ArrayList<>();

    public void addProduct(Product product){
            goods.add(product);
            product.getOrders().add(this);
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public String toString() {
        return "Order " + id +  " was made on " + date + "\nGoods purchased" + goods + "\nClient: " + client;
    }
}
