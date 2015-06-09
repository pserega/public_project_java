package accountServer;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

/**
 * Created by jim on 3/13/15.
 */
public interface AccountServerI {
    void addNewUser();
    
    void removeUser();

    int getUsersLimit();

    void setUsersLimit(int usersLimit);

    int getUsersCount();
    
    void registerMBean() throws MalformedObjectNameException,MBeanRegistrationException,InstanceAlreadyExistsException,NotCompliantMBeanException;
}
