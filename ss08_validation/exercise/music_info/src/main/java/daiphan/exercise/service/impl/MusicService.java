package daiphan.exercise.service.impl;

import daiphan.exercise.model.Music;
import daiphan.exercise.repository.IMusicRepository;
import daiphan.exercise.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).get();
    }

    @Override
    public Page<Music> findByName(String keySearch, Pageable pageable) {
        return musicRepository.findByName(keySearch, pageable);
    }
}
