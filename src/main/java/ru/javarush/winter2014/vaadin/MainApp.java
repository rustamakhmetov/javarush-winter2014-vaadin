package ru.javarush.winter2014.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import org.jdal.vaadin.ui.Box;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Main Application UI
 */
@Theme("sample")
@PreserveOnRefresh
@Title("Users Sample")
public class MainApp extends UI {

    protected VerticalLayout root = new VerticalLayout();
    protected HorizontalLayout top = new HorizontalLayout();
    private Panel mainView = new Panel();
    @Autowired
    private ViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest request) {
        addStyleNames();
        root.setSizeFull();
        Navigator navigator = new Navigator(this, mainView);
        navigator.addProvider(viewProvider);
        setContent(root);
        mainView.setSizeFull();
        buildMain();
    }

    /**
     * Build application main window
     */
    protected void buildMain() {
        this.root.removeAllComponents();
        this.top.setWidth(100, Unit.PERCENTAGE);
        this.top.setSpacing(false);
        this.top.setMargin(false);

        this.root.addComponent(top);
        this.root.addComponent(mainView);

        this.root.setSpacing(false);
        this.root.setMargin(false);
        this.root.setExpandRatio(top, 0);
        this.root.setExpandRatio(mainView, 1);

        Label logo = new Label("Users");
        logo.setStyleName("app-title");
        logo.setSizeUndefined();
        this.top.addComponent(logo);
        this.top.setComponentAlignment(logo, Alignment.MIDDLE_RIGHT);

        Box.addHorizontalStruct(top, 20);
    }

    protected void addStyleNames() {
        this.root.addStyleName("jd-app-root");
        this.top.addStyleName("jd-app-top");
        this.mainView.addStyleName("jd-app-main");
        this.mainView.addStyleName(Reindeer.PANEL_LIGHT);
    }

    public Panel getMainView() {
        return mainView;
    }

    public void setMainView(Panel mainView) {
        this.mainView = mainView;
    }

    public ViewProvider getViewProvider() {
        return viewProvider;
    }

    public void setViewProvider(ViewProvider viewProvider) {
        this.viewProvider = viewProvider;
    }
}


