package ru.javarush.winter2014.dao.hibernate;

import org.hibernate.Criteria;
import org.jdal.dao.hibernate.AbstractCriteriaBuilder;
import ru.javarush.winter2014.dao.filter.UserFilter;

/**
 * Criteria Builder for User Filter
 */
public class UserCriteriaBuilder extends AbstractCriteriaBuilder {

    public Criteria build(Criteria criteria, Object filter) {
        UserFilter f = (UserFilter) filter;

        like(criteria, "name", f.getName());
        eq(criteria, "admin", f.getAdmin());
        le(criteria, "createDate", f.getBefore());
        ge(criteria, "createDate", f.getAfter());

        return criteria;
    }

}
