/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a6;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author mark
 */
public class A6 {
private static final String PERSISTENCE_UNIT_NAME = "a6PU";
  private static EntityManagerFactory factory;

  public static void main(String[] args) {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    // read the existing entries and write to console
    Query q = em.createQuery("select t from GameLive t ");
    List<GameLive> list = q.getResultList();
    for (GameLive game : list) {
      System.out.println(game);
    }
    System.out.println("Size: " + list.size());

    // create new todo
    em.getTransaction().begin();
    GameLive game = new GameLive();
    game.setId(2);
    game.setCardRow("1,2,3");
    game.setP1Hand("4");
    game.setP2Hand("5");
    
    em.persist(game);
    em.getTransaction().commit();

    em.close();
  }
    
}
