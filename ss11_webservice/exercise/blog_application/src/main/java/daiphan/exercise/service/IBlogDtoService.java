package daiphan.exercise.service;

import daiphan.exercise.dto.IBlogDto;

import java.util.List;

public interface IBlogDtoService {

    List<IBlogDto> searchByTitle(String title);
}
