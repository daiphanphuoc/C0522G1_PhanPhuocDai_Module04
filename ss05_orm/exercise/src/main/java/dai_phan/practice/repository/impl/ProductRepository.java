package dai_phan.practice.repository.impl;

import dai_phan.practice.model.Product;
import dai_phan.practice.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    //private static Map<Integer, Product> productMap = new HashMap<>();

  /*  static {
        productMap.put(1, new Product(1, "Bánh chưng", 5000, "dùng tốt", "Hương"));
        productMap.put(2, new Product(2, "Bánh Tét", 5000, "dùng tốt", "Hương"));
        productMap.put(3, new Product(3, "Bánh dày", 5000, "dùng tốt", "Hương"));
        productMap.put(4, new Product(4, "Bánh ít", 5000, "dùng tốt", "Hương"));
        productMap.put(5, new Product(5, "Bánh gói", 5000, "dùng tốt", "Hương"));
    }*/

    @Override
    public List<Product> productAll() {
        List<Product> productList = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            productList = session.createQuery("from Product ").getResultList();

        }

        return productList;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            Query query = session.createQuery("from Product p where p.name like :param");
            query.setParameter("param", "%" + name + "%");
            productList = query.getResultList();
        }
        return productList;
    }

    @Override
    public Product insert(Product product) {
        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return null;
            }
        }

        return product;
    }

    @Override
    public Product update(Product product) {
        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return null;
            }
        }

        return product;
    }

    @Override
    public Product delete(Product product) {
        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.delete(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return null;
            }
        }
        return product;
    }

    @Override
    public Product detail(int id) {
        Product product = null;
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            Query query = session.createQuery("from Product p where p.id = :param");
            query.setParameter("param", id);
            product = (Product) query.getSingleResult();
        }
        return product;
    }
}
