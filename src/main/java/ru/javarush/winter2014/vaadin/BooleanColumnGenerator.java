package ru.javarush.winter2014.vaadin;

import com.vaadin.data.Property;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

/**
 * rahmetov
 * 26.12.2014.
 */
public class BooleanColumnGenerator implements Table.ColumnGenerator {
    private static final long serialVersionUID = -1365109458526609567L;

    public BooleanColumnGenerator() {
    }

    /**
     * Generates the cell containing the Double value. The column is
     * irrelevant in this use case.
     */
    public Component generateCell(Table source, Object itemId,
                                  Object columnId) {
        Property prop = source.getItem(itemId).getItemProperty(columnId);
        boolean val = (Boolean)prop.getValue();

        CheckBox ret = new CheckBox("", val);
        ret.setReadOnly(true);

        return ret;
    }

}
