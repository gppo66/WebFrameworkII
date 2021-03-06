package helloHibernate;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 	
@ToString

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int id;

	private String name;

	private int price;

	private String description;

//	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
}
