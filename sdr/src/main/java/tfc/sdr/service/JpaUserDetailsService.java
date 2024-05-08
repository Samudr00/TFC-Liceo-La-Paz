//package tfc.sdr.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class JpaUserDetailsService implements UserDetailsService {
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if(!username.equals("rico")) {
//			throw new UsernameNotFoundException(String.format("El usuario %s no existe", username));
//		}
//		
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority("ADMINISTRADOR"));
//		
//		return new User(
//				username,
//				"rico123",
//				true,
//				true,
//				true,
//				true,
//				authorities);
//	}
//
//}
