package ru.javarush.winter2014.vaadin;

import javax.annotation.PostConstruct;

import com.vaadin.ui.*;
import ru.javarush.winter2014.dao.filter.UserFilter;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;

/**
 * User Filter
 */
public class UserFilterView extends AbstractView<UserFilter> {

    private TextField name = FormUtils.newTextField();
    private CheckBox admin = new CheckBox();
    private DateField before = new DateField();
    private DateField after = new DateField();

    public UserFilterView() {
        this(new UserFilter());
    }

    public UserFilterView(UserFilter model) {
        super(model);
    }

    @PostConstruct
    public void init() {
        autobind();
        setInitializeControls(false);
        refresh();
    }

    /**
     * Build {@link org.jdal.ui.View} component using a {@link BoxFormBuilder}
     */
    @Override
    protected Component buildPanel() {
        BoxFormBuilder fb = new BoxFormBuilder();
        fb.setMargin(false);

        fb.row();
        fb.add(name, getMessage("User.name"), BoxFormBuilder.SIZE_FULL);
        fb.add(before, getMessage("UserFilter.createBefore"));
        fb.add(after, getMessage("UserFilter.createAfter"));
        fb.add(admin, getMessage("User.admin"), 50, Alignment.MIDDLE_CENTER);
        return fb.getForm();
    }

}
