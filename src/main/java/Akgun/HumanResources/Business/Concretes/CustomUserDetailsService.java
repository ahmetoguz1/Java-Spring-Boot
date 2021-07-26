package Akgun.HumanResources.Business.Concretes;

import Akgun.HumanResources.DataAccess.Abstracts.UserRepository;
import Akgun.HumanResources.Entities.Concretes.MyUserDetails;
import Akgun.HumanResources.Entities.Concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
/*
Used for user authentication service
*/
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserName(username);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return optionalUser.map(MyUserDetails::new).get();
    }

}