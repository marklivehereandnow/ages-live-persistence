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
public class TakeCard {
private static final String PERSISTENCE_UNIT_NAME = "a6PU";
  private static EntityManagerFactory factory;

  public static void main(String[] args) {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    // read the existing entries and write to console
    Query q = em.createQuery("select t from GameLive t where t.id=1");
    List<GameLive> list = q.getResultList();
    if (list.size()!=1){
        System.out.println("ERROR, record not found!");
        return;
    }
    
    GameLive game = list.get(0);    
    game.setCardRow("1,2,0,4,5,6,7,8,9,10,11,12,13");
    game.setP1Hand("3");
    
    em.getTransaction().begin();
    em.persist(game);
    em.getTransaction().commit();

    em.close();
  }
    
}
