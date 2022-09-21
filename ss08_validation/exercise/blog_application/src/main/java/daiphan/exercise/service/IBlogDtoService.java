package daiphan.exercise.service;

import daiphan.exercise.dto.BlogDto;
import daiphan.exercise.dto.IBlogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogDtoService {

    Page<IBlogDto> searchByTitle(String title, Pageable pageable);
}
