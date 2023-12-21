/* У класі BookHelper створити метод, який отримує назву книги та ім'я автора. */

package task2;


import jakarta.persistence.*;

public class BookHelper {
    public BookHelper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("authorhelper");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
    }

    @PersistenceContext // приміняється для EntityManager
    private EntityManager entityManager;

    public Book getBookByTitleAndAuthor(String title, String author) {
        return (Book) entityManager.createQuery("From Book b WHERE b.title = :title AND b.author = :author")
                .setParameter("title", title)
                .setParameter("author", author)
                .getSingleResult();
    }
}










