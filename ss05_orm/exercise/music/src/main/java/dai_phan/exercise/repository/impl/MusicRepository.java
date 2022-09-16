package dai_phan.exercise.repository.impl;

import dai_phan.exercise.model.Music;
import dai_phan.exercise.repository.IMusicRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {


    @Override
    public List<Music> musicAll() {
        List<Music> musicList = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            musicList = session.createQuery("from Music ").getResultList();

        }

        return musicList;
    }

    @Override
    public List<Music> searchByName(String name) {
        List<Music> musicList = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            Query query = session.createQuery("from Music p where p.name like ?1");
            query.setParameter(1, "%" + name + "%");
            musicList = query.getResultList();
        }
        return musicList;
    }

    @Override
    public Music insert(Music music) {
        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.save(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return null;
            }
        }

        return music;
    }

    @Override
    public Music update(Music music) {
        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.update(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return null;
            }
        }

        return music;
    }

    @Override
    public Music delete(Music music) {
        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.delete(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                return null;
            }
        }
        return music;
    }

    @Override
    public Music detail(int id) {
        Music music = null;
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            Query query = session.createQuery("from Music p where p.id = :param");
            query.setParameter("param", id);
            music = (Music) query.getSingleResult();
        }
        return music;
    }
}
