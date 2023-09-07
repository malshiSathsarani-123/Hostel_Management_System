package lk.ijse.hostel.dao;

import lk.ijse.hostel.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }
    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes {
     PAYMENT,QUERY,RESERVATION,ROOM,STUDENT,USER
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case PAYMENT:
                return new PaymentDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
