package accountServer;

import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;


public class AccountServer implements AccountServerI {
    private int usersCount;
    private int usersLimit;

    public AccountServer(int usersLimit) {
        this.usersCount = 0;
        this.usersLimit = usersLimit;
    }

    @Override
    public void addNewUser() {
        usersCount += 1;
    }

    @Override
    public void removeUser() {
        usersCount -= 1;
    }

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    @Override
    public int getUsersCount() {
        return usersCount;
    }

    /**
     *
     * @throws javax.management.MalformedObjectNameException
     * @throws javax.management.MBeanRegistrationException
     * @throws javax.management.InstanceAlreadyExistsException
     * @throws javax.management.NotCompliantMBeanException
     */
    @Override
    public void registerMBean() throws MalformedObjectNameException,MBeanRegistrationException,InstanceAlreadyExistsException,NotCompliantMBeanException{
       AccountServerControllerMBean serverStatistics = new AccountServerController(this);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ServerManager:type=AccountServerController");
        ObjectInstance objectInstance = mbs.registerMBean(serverStatistics, name);
    }
    
    
}
