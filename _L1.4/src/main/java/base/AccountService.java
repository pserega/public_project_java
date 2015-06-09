package base;

import java.util.HashMap;
import java.util.Map;

public class AccountService implements IAccountService {
    
    private Map<String, UserProfile> users = new HashMap<>();
    private Map<String, UserProfile> sessions = new HashMap<>();

    @Override
    public boolean addUser(String userName, UserProfile userProfile) {
        if (users.containsKey(userName))
            return false;
        users.put(userName, userProfile);
        return true;
    }

    @Override
    public void addSessions(String sessionId, UserProfile userProfile) {
        sessions.put(sessionId, userProfile);
    }

    @Override
    public UserProfile getUser(String userName) {
        return users.get(userName);
    }

    @Override
    public UserProfile getSessions(String sessionId) {
        return sessions.get(sessionId);
    }
}
