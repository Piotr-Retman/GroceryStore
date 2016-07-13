package com.grocerystore.impl.userimpl;

import com.grocerystore.entities.Users;
import com.grocerystore.except.ExceptionUtil;
import com.grocerystore.except.UserManagementException;
import com.grocerystore.hib.HibernateUtil;
import com.grocerystore.impl.interfaces.users.UserInterface;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

/**
 * Created by retman on 11.07.16.
 */
public class UserImpl implements UserInterface {

    private final String queryToSearchByUserId = "select users.user_id as userId,users.user_type as userType,users.username,users.first_name as firstName,users.surname from users where users.user_id = :id";

    public Users retrieveOneUserBasedOnId(String userId) throws UserManagementException {
        List users = connectToGetListOfUsers(queryToSearchByUserId, userId);
        if (isListHaveCorrectValues(users)) {
            ExceptionUtil exceptionUtil = new ExceptionUtil();
            throw new UserManagementException(exceptionUtil.getErrorLog("error.not.found.user"));
        }
        return serializeUser(users);
    }

    public Users retrieveOneUserBasedOnUsernameAndPassword(String username, String password) throws UserManagementException {
        Session session = HibernateUtil.buildSessionFactory();

        Query query = session.getNamedQuery("find").setParameter("username",username).setParameter("password",password);
        List list = query.list();
        Users users = null;
        if(isListHaveCorrectValues(list)){
            ExceptionUtil exceptionUtil = new ExceptionUtil();
            throw new UserManagementException(exceptionUtil.getErrorLog("error.not.found.user"));
        }
        users = serializeUser(list);
        session.close();
        return users;
    }

    private Users serializeUser(List users) {
        Users user = new Users();
        for (Iterator iterator = users.iterator(); iterator.hasNext(); ) {
            Object[] userDataBeforeSerialization = (Object[]) iterator.next();
            user.setUserId((Integer) userDataBeforeSerialization[0]);
            user.setUserType((String) userDataBeforeSerialization[2]);
            user.setUserName((String) userDataBeforeSerialization[1]);
            user.setSurname((String) userDataBeforeSerialization[4]);
            user.setFirstName((String) userDataBeforeSerialization[3]);
        }
        return user;
    }

    private List connectToGetListOfUsers(String... params) {
        Session session = HibernateUtil.buildSessionFactory();
        String[] paramsArray = params;
        String queryToGetById = paramsArray[0];
        int userId = Integer.valueOf(paramsArray[1]);
        Query query = session.createSQLQuery(queryToGetById);
        query.setParameter("id", userId);
        List list = query.list();
        session.close();
        return list;
    }

    private boolean isListHaveCorrectValues(List list) {
        return list.isEmpty() || list.size() > 2;
    }
}
