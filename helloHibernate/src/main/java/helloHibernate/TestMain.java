package helloHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class TestMain {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		/*
		 * Configuration conf = new Configuration(); conf.configure(); sessionFactory =
		 * conf.buildSessionFactory();
		 */
		// chained method
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Product product1 = new Product();
		product1.setName("Notebook1");
		product1.setPrice(2000);
		product1.setDescription("Awesome notebook!!");

		Product product2 = new Product();
		product2.setName("Notebook2");
		product2.setPrice(3000);
		product2.setDescription("Powerful notebook!!");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		/*Serializable id1 = session.save(product1);*/
		session.save(product1);
		session.save(product2);

		/*Product savedProduct = session.get(Product.class, id1);
		System.out.println("saved product" + savedProduct);*/

		Query<Product> aQuery = session.createQuery("from Product",Product.class); //HQL
		List<Product> products = aQuery.getResultList();

		System.out.println(products);

		tx.commit();

		session.close();
		sessionFactory.close();

	}

}
