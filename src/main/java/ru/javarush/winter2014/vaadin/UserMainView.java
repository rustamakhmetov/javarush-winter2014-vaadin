package ru.javarush.winter2014.vaadin;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import ru.javarush.winter2014.model.User;
import org.jdal.vaadin.ui.table.PageableTable;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class UserMainView extends VerticalLayout implements View {
	
	@Resource
	private PageableTable<User> bookPageableTable;
	
	@PostConstruct
	public void init() {
		setSizeFull();
		this.bookPageableTable.setWidthFull();
		setMargin(true);
		addComponent(bookPageableTable);

	}
	
	/**
	 * Refresh table when entering in the View
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		this.bookPageableTable.refresh();
	}

}
