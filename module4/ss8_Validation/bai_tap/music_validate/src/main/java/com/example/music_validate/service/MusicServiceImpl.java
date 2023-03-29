package com.example.music_validate.service;

import com.example.music_validate.entity.Music;
import com.example.music_validate.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{
    @Autowired
    private MusicRepository musicRepository;
    @Override
    public List<Music> findAll() {
        return  musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);

    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }
}
