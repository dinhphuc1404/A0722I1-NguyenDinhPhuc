package com.example.xay_dung_ung_dung_nghe_nhac.service;

import com.example.xay_dung_ung_dung_nghe_nhac.entity.Music;
import com.example.xay_dung_ung_dung_nghe_nhac.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MusicServiceImpl implements  MusicService {
    private MusicRepository musicRepository;
    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public MusicServiceImpl() {

    }

    @Transactional
    @Override
    public void create(Music music) {
        musicRepository.create(music);

    }
    @Transactional
    @Override
    public void update(Music music) {
        musicRepository.update(music);

    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);

    }

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id);
    }
}
