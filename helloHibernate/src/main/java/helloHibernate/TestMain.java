package helloHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class TestMain {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		/*
		 * Configuration conf = new Configuration(); conf.configure(); sessionFactory =
		 * conf.buildSessionFactory();
		 */
		// chained method
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Category category1 = new Category();
		category1.setName("컴퓨터");

		Category category2 = new Category();
		category2.setName("자동차");


		Product product1 = new Product();
		product1.setName("Notebook1");
		product1.setPrice(2000);
		product1.setDescription("Awesome notebook!!");
		product1.setCategory(category1);
		category1.getProducts().add(product1);

		Product product2 = new Product();
		product2.setName("Notebook2");
		product2.setPrice(3000);
		product2.setDescription("Powerful notebook!!");
		product2.setCategory(category1);
		category1.getProducts().add(product2);

		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(100000);
		product3.setDescription("Awesome Car!!");
		product3.setCategory(category2);
		category2.getProducts().add(product3);

		//session 1
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		/*Serializable id1 = session.save(product1);*/
		/*session.save(product1);
		session.save(product2);
		session.save(product3);*/

		Serializable cid1= session.save(category1);
		Serializable cid2 =session.save(category2);


		/*session.delete(category1);*/

		/*session.delete(product3); // cascade all 로 인해 category2도 삭제
		product1.setCategory(null);//category1과 product1과의 연결을 끊어버림
		session.delete(product1); // product1,2 -> category1 cascade를 끊어줘야함*/

		/*Product savedProduct = session.get(Product.class, id1);
		System.out.println("saved product" + savedProduct);*/

		/*Query<Product> aQuery = session.createQuery("from Product",Product.class); //HQL
		List<Product> products = aQuery.getResultList();

		System.out.println(products);
*/

		tx.commit();

		session.close();

		//session2
		Session session2 = sessionFactory.openSession();
		Transaction tx2 = session2.beginTransaction();

		Category aCategory = session2.get(Category.class,cid1);

		Set<Product> products = aCategory.getProducts();

		for(Product p: products)
			System.out.println(p.getName());

		tx2.commit();

		session2.close();

		sessionFactory.close();

	}

}
