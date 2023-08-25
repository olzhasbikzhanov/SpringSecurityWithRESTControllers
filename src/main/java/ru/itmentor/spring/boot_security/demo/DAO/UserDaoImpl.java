//package ru.itmentor.spring.boot_security.demo.DAO;
//
//import org.springframework.stereotype.Repository;
//import ru.itmentor.spring.boot_security.demo.models.User;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//@Repository
//public class UserDaoImpl implements UserDao {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<User> indexUser() {
//        return entityManager.createQuery("FROM User", User.class).getResultList();
//    }
//
//    @Override
//    public User show(int id) {
//        return entityManager.find(User.class,id);
//    }
//
//    @Override
//    public void save(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    public void update(int id, User updatedUser) {
//        User userToBeUpdated = entityManager.find(User.class, id);
//        userToBeUpdated.setUsername(updatedUser.getUsername());
//        userToBeUpdated.setAge(updatedUser.getAge());
//        userToBeUpdated.setPassword(updatedUser.getPassword());
//    }
//
//    @Override
//    public void delete(int id) {
//        entityManager.remove(entityManager.find(User.class, id));
//    }
//}
