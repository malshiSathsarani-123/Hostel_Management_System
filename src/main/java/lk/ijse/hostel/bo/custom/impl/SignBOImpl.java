package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.SignBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.dto.UserDto;
import lk.ijse.hostel.entity.User;

public class SignBOImpl implements SignBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean save(UserDto userDto) {
        return userDAO.save(new User(userDto.getUserName(),userDto.getPassword()));
    }
}
