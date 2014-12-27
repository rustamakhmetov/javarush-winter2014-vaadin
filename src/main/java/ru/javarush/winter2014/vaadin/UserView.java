package ru.javarush.winter2014.vaadin;

import javax.annotation.PostConstruct;

import ru.javarush.winter2014.model.User;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.form.BoxFormBuilder;
import org.jdal.vaadin.ui.form.SimpleBoxFormBuilder;

import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.CheckBox;



/**
 * User Editor
 */
public class UserView extends AbstractView<User> {

	private TextField name = new TextField();
	private TextField age = new TextField();
	private CheckBox admin = new CheckBox();
	private DateField createDate = new DateField();

	public UserView() {
		this(new User());
	}

	public UserView(User model) {
		super(model);
	}

	@PostConstruct
	public void init()  {
		autobind();
	}
	
	@Override
	protected Component buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.setDefaultWidth(SimpleBoxFormBuilder.SIZE_FULL);
		fb.setFixedHeight();
		
		fb.row();
		fb.add(name, getMessage("User.name"));
		fb.row();
		fb.startBox();
		fb.row();
		fb.add(age, getMessage("User.age"));
		fb.add(createDate, getMessage("User.createDate"), 120);
		fb.endBox();
		fb.row();
		fb.startBox();
		fb.row();
		fb.add(admin, getMessage("User.admin"));
		fb.endBox();
		return fb.getForm();
	}
	
	@Override
	public String getName() {
		User model = getModel();
		
		if (model != null && model.getId() != null) {
			return model.getName();
		}
		
		return null;
	}

}
