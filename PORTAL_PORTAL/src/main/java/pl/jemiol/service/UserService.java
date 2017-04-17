package pl.jemiol.service;

import org.springframework.stereotype.Service;

import pl.jemiol.model.User;

@Service
public interface UserService {
	public void save(User user);

	public User findByUsername(String username);

	public boolean addFriend(User loggedUser, User invitedFriends);

	public boolean sendInviteToFriends(User loggedUser, User toInvite);
	
	public boolean acceptInvitedToFriends(User loggedUser, User userToAccept);
	
	public boolean deleteInvite(User loggedUser, User userToDeleteInvite);

}
