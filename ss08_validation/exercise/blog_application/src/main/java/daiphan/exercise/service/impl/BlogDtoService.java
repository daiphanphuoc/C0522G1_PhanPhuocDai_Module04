package daiphan.exercise.service.impl;

import daiphan.exercise.dto.IBlogDto;
import daiphan.exercise.repository.IBlogRepository;
import daiphan.exercise.service.IBlogDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogDtoService implements IBlogDtoService {

    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<IBlogDto> searchByTitle(String title, Pageable pageable) {
        return blogRepository.searchInterface(title, pageable);
    }

}
