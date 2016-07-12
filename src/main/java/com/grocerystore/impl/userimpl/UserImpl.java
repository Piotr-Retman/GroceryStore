package com.grocerystore.impl.userimpl;

import com.grocerystore.entities.User;
import com.grocerystore.hib.HibernateUtil;
import com.grocerystore.impl.interfaces.users.UserInterface;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by retman on 11.07.16.
 */
public class UserImpl implements UserInterface {
    public User retrieveOneUserBasedOnId(int i) {
        Session session = HibernateUtil.buildSessionFactory();
        String queryToGetById = "select user.user_type,users.username,users.first_name,users.surname from users where users.user_id =:id";
        Query query = session.createSQLQuery(queryToGetById);
        query.setInteger(i,1);
        User user = (User)query.uniqueResult();
        session.close();
        return user;
    }
}
