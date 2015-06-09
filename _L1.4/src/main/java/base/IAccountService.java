/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Sergey_Prig
 */
public interface IAccountService {
    
    public boolean addUser(String userName, UserProfile userProfile);
    
    public void addSessions(String sessionId, UserProfile userProfile);
    
    public UserProfile getUser(String userName);
    
    public UserProfile getSessions(String sessionId);    
}
