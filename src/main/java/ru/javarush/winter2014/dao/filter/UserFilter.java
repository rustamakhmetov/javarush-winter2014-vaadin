package ru.javarush.winter2014.dao.filter;

import java.util.Date;

import org.jdal.dao.BeanFilter;

/**
 * Filter for Users
 */
public class UserFilter extends BeanFilter {

    private String name = "";
    private Boolean admin;
    private Date before;
    private Date after;

    public UserFilter() {
        this("user");
    }

    public UserFilter(String filterName) {
        super(filterName);
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the before
     */
    public Date getBefore() {
        return before;
    }

    /**
     * @param before the before to set
     */
    public void setBefore(Date before) {
        this.before = before;
    }

    /**
     * @return the after
     */
    public Date getAfter() {
        return after;
    }

    /**
     * @param after the after to set
     */
    public void setAfter(Date after) {
        this.after = after;
    }

}
