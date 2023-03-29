package com.example.music_validate.service;

import com.example.music_validate.entity.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();
    void save(Music music);
    Music findById(Long id);
}
