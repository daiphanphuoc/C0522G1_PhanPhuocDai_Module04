package dai_phan.exercise.service.impl;

import dai_phan.exercise.model.Music;
import dai_phan.exercise.repository.IMusicRepository;
import dai_phan.exercise.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository productRepository;

    @Override
    public List<Music> musicAll() {
        return  productRepository.musicAll();
    }

    @Override
    public List<Music> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    @Override
    public Music insert(Music music) {
        return productRepository.insert(music);
    }

    @Override
    public Music update(Music music) {
        return productRepository.update(music);
    }

    @Override
    public Music delete(Music music) {
        return productRepository.delete(music);
    }

    @Override
    public Music detail(int id) {
        return productRepository.detail(id);
    }
}
