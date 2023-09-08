package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.LoginBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.custom.UserDAO;

public class LoginBOImpl implements LoginBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean conform(String name, String password) {
        return userDAO.conform(name,password);
    }
}
