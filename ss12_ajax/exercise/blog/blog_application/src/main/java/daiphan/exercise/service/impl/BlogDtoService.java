package daiphan.exercise.service.impl;

import daiphan.exercise.dto.IBlogDto;
import daiphan.exercise.repository.IBlogRepository;
import daiphan.exercise.service.IBlogDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogDtoService implements IBlogDtoService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<IBlogDto> searchByTitle(String title) {
        return blogRepository.searchInterface(title);
    }

}
