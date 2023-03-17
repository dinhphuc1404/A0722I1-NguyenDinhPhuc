package com.example.xay_dung_ung_dung_nghe_nhac.repository;

import com.example.xay_dung_ung_dung_nghe_nhac.entity.Music;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class MusicRepositoryImpl implements MusicRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void create(Music music) {
        entityManager.persist(music);

    }

    @Override
    public void update(Music music) {
        entityManager.merge(music);

    }

    @Override
    public void delete(int id) {
        Music music=findById(id);
        entityManager.remove(entityManager.merge(music));

    }

    @Override
    public List<Music> findAll() {
        return entityManager.createQuery("select m from Music m").getResultList();
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class,id);
    }
}
