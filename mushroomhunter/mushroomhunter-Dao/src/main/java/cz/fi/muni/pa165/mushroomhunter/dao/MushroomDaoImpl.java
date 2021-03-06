package cz.fi.muni.pa165.mushroomhunter.dao;

import cz.fi.muni.pa165.mushroomhunter.entity.Location;
import cz.fi.muni.pa165.mushroomhunter.entity.Mushroom;
import cz.fi.muni.pa165.mushroomhunter.api.Type;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Simon Hochla
 */
@Repository
public class MushroomDaoImpl implements MushroomDao {

    /**
     * Entity manager.
     */
    @PersistenceContext
    private EntityManager em;

    @Override
    public long save(Mushroom mushroom) {
        em.persist(mushroom);
        return mushroom.getId();
    }

    @Override
    public Mushroom update(Mushroom mushroom) {
        return em.merge(mushroom);
    }

    @Override
    public void delete(Mushroom mushroom) {
        if (!em.contains(mushroom)) {
            mushroom = em.merge(mushroom);
        }
        em.remove(mushroom);
    }

    @Override
    public Mushroom find(long id) {
        final Query query = em.createQuery("SELECT m FROM Mushroom m WHERE id = :id");
        query.setParameter("id", id);
        return (Mushroom) query.getSingleResult();
    }

    @Override
    public List<Mushroom> findAll() {
        final Query query = em.createQuery("SELECT m FROM Mushroom m");
        return (List<Mushroom>) query.getResultList();
    }

    @Override
    public List<Mushroom> findByName(String name) {
        final Query query = em.createQuery("SELECT m FROM Mushroom m WHERE name = :name");
        query.setParameter("name", name);
        return (List<Mushroom>) query.getResultList();
    }

    @Override
    public List<Mushroom> findByLocation(Location loc) {
        final Query query = em.createQuery("SELECT m FROM Mushroom m, Visit v WHERE m.id = (SELECT key(map) FROM v.foundMushrooms map WHERE v.location = :location)");
        query.setParameter("location", loc);
        return (List<Mushroom>) query.getResultList();
    }

    @Override
    public List<Mushroom> findByType(Type type) {
        final Query query = em.createQuery("SELECT m FROM Mushroom m WHERE type = :type");
        query.setParameter("type", type);
        return (List<Mushroom>) query.getResultList();
    }

    @Override
    public List<Mushroom> findByOccurenceDate(Date startOfOccurence, Date endOfOccurence) {
        final Query query = em.createQuery("SELECT m FROM Mushroom m "
                + "WHERE m.startOfOccurence BETWEEN :startOfOccurence AND :endOfOccurence "
                + "OR m.endOfOccurence BETWEEN :startOfOccurence AND :endOfOccurence "
                + "OR :startOfOccurence BETWEEN m.startOfOccurence AND m.endOfOccurence "
                + "OR :endOfOccurence BETWEEN m.startOfOccurence AND m.endOfOccurence "
                + "OR m.endOfOccurence BETWEEN :startOfOccurence AND :endOfOccurence");
        query.setParameter("startOfOccurence", startOfOccurence);
        query.setParameter("endOfOccurence", endOfOccurence);

        return (List<Mushroom>) query.getResultList();
    }

}
