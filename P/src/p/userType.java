package p;

/*
public enum userType
{
ADMIN,
USER;
}
 */
/**
 *
 * @author prigs
 */
public enum userType {

    /**
     *
     */
    ADMIN(1),
    /**
     *
     */
    USER(2);
    private int id;

    private userType(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }
}
