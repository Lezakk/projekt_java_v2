package pl.wsb.projekt.springmvcprojektapp.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.wsb.projekt.springmvcprojektapp.auth.toDoListUserDetails;
import pl.wsb.projekt.springmvcprojektapp.model.User;
import pl.wsb.projekt.springmvcprojektapp.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class toDoListUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public toDoListUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Nie ma takiego użytkownika: " + username));
        return toDoListUserDetails.build(user);
    }

}
