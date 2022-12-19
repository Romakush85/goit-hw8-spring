package ua.goit.hw8.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.hw8.model.dto.UserDto;
import ua.goit.hw8.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InMemoryUserDetailsService implements UserDetailsService {
    private final UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserDto userDto = service.findByEmail(username);
            return new UserDetails() {
                @Override
                public List<SimpleGrantedAuthority> getAuthorities() {
                    return userDto.getRoles().stream()
                            .map(role ->
                                    new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList());
                }

                @Override
                public String getPassword() {
                    return userDto.getPassword();
                }

                @Override
                public String getUsername() {
                    return userDto.getEmail();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }

                public String getFirstName(){ return userDto.getFirstName();}
            };
        } catch (ResponseStatusException e) {
            throw new UsernameNotFoundException(username);
        }

    }
}
