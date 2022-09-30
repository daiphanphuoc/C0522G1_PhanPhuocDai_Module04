package daiphan.exercise.service.impl;

import daiphan.exercise.model.MyUserDetail;
import daiphan.exercise.model.User;
import daiphan.exercise.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByName(username);

        if(user==null){
            throw new UsernameNotFoundException("User name ko tồn tại");
        }
        return new MyUserDetail(user);
    }
}
