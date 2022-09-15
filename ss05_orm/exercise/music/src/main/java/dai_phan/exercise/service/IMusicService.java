package dai_phan.exercise.service;

import dai_phan.exercise.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> musicAll();

    List<Music> searchByName(String name);

    Music insert(Music music);

    Music update(Music music);

    Music delete(Music music);

    Music detail(int id);
}
