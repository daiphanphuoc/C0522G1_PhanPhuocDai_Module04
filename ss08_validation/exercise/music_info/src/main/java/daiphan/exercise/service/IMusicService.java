package daiphan.exercise.service;

import daiphan.exercise.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {

    Music findById(int id);

    Page<Music> findByName(String keySearch, Pageable pageable);

    void save(Music music);
}
