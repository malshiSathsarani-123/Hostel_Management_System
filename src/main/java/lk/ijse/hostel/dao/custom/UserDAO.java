package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SuperDAO;
import lk.ijse.hostel.entity.User;

public interface UserDAO extends SuperDAO {
    boolean save(User user);

    boolean conform(String name, String password);

}
