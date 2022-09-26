package daiphan.exercise.service;

import daiphan.exercise.dto.BlogDto;
import daiphan.exercise.dto.IBlogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogDtoService {

    List<IBlogDto> searchByTitle(String title);
}
