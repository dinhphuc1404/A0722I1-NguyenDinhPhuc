package com.example.xay_dung_ung_dung_nghe_nhac.repository;

import com.example.xay_dung_ung_dung_nghe_nhac.entity.Music;

import java.util.List;

public interface MusicRepository {
    void create(Music music);

    void update(Music music);

    void delete(int id);

    List<Music> findAll();

    Music findById(int id);
}
