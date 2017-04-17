package pl.jemiol.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.jemiol.model.User;
import pl.jemiol.other.Roles;
import pl.jemiol.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	UserRepository userRepository;
	/**
	 * 
	 */
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRoles(Roles.USER);
		logger.warning("before save");
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public boolean addFriend(User loggedUser, User userToAdd) {
		List<User> friendsOfLoggedUser = loggedUser.getFriends();
		List<User> friendsOfUserToAdd = userToAdd.getFriends();
		if (!friendsOfLoggedUser.contains(userToAdd) && !friendsOfUserToAdd.contains(loggedUser)) {
			friendsOfLoggedUser.add(userToAdd);
			friendsOfUserToAdd.add(loggedUser);
			return true;
		}
		return false;
	}

	@Override
	public boolean sendInviteToFriends(User loggedUser, User toInviteUser) {
		List<User> invitedFriends = loggedUser.getInvitedFriends();
		List<User> invitedBy = toInviteUser.getInvitedBy();
		if (!invitedFriends.contains(toInviteUser) && !invitedBy.contains(loggedUser)) {
			invitedFriends.add(toInviteUser);
			invitedBy.add(loggedUser);
			userRepository.save(loggedUser);
			userRepository.save(toInviteUser);
					for(User user : invitedFriends) {
						logger.warning(user.getUsername());
					}
			return true;
		}
		return false;
	}

	@Override
	public boolean acceptInvitedToFriends(User loggedUser, User userToAccept) {
		List<User> listOfUsersToAccept = loggedUser.getInvitedBy();
		List<User> listOfInvitedToFriends = userToAccept.getInvitedFriends();

		if (listOfUsersToAccept.contains(userToAccept) && listOfInvitedToFriends.contains(loggedUser)) {
			if (deleteInvite(loggedUser, userToAccept)) {
				if (addFriend(loggedUser, userToAccept)) {
					userRepository.save(loggedUser);
					userRepository.save(userToAccept);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteInvite(User loggedUser, User userToDeleteInvite) {
		List<User> listOfInvitedUserToFriends = loggedUser.getInvitedFriends();
		List<User> listOfUsersToBeAccept = userToDeleteInvite.getInvitedBy();
		if (listOfInvitedUserToFriends.contains(userToDeleteInvite) && listOfUsersToBeAccept.contains(loggedUser)) {
			listOfInvitedUserToFriends.remove(userToDeleteInvite);
			listOfUsersToBeAccept.remove(loggedUser);
			userRepository.save(loggedUser);
			userRepository.save(userToDeleteInvite);
			return true;
		}
		return false;
	}

}
