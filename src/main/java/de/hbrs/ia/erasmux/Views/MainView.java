package de.hbrs.ia.erasmux.Views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.hbrs.ia.erasmux.Entity.SalesMan;
import de.hbrs.ia.erasmux.Entity.SalesMenEnum;
import de.hbrs.ia.erasmux.Repository.SalesmanRepository;

import com.vaadin.flow.component.AbstractField;

import java.util.Objects;

////
@Route(value = "")
@PageTitle("Salesmen")
public class MainView extends VerticalLayout {
    Grid<SalesMan> grid = new Grid<>();
    TextField filterText = new TextField();
    SalesmanRepository salesmanRepository;

    public MainView(SalesmanRepository salesmanRepository) {
        this.salesmanRepository = salesmanRepository;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        grid.setItems(salesmanRepository.findAll());
        add(getToolbar(), grid);
        setFilterBy(SalesMenEnum.SID);
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.setValueChangeTimeout(300);
        Button addSearchButton = new Button("Search contact");
        var toolbar = new HorizontalLayout(filterText, addSearchButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addColumn(SalesMan::getFirstName)
                .setSortable(true)
                .setComparator(SalesMan::getFirstName)
                .setKey("FirstName")
                .setHeader("Unternehmen");
//                .setHeader("FirstName");
        grid.addColumn(SalesMan::getLastName)
                .setSortable(true)
                .setComparator(SalesMan::getLastName)
                .setKey("LastName")
                .setHeader("LastName");
        grid.addColumn(SalesMan::getEmail)
                .setSortable(true)
                .setComparator(SalesMan::getEmail)
                .setKey("Email")
                .setHeader("Email");
        grid.addColumn(SalesMan::getSid)
                .setSortable(true)
                .setComparator(SalesMan::getSid)
                .setKey("Sid")
                .setHeader("Sid");
    }

    private void setFilterBy(SalesMenEnum searchBy) {
        filterText.addValueChangeListener(
                (AbstractField.ComponentValueChangeEvent<TextField, String> event) -> {
                    String inputSearchNameFilter = event.getValue();
                    ((ListDataProvider<SalesMan>) grid.getDataProvider()).
                            setFilter((SalesMan salesMan) -> filterFunction(salesMan, inputSearchNameFilter, searchBy));
//                                    salesMan.getFirstName().toLowerCase().contains(inputSearchNameFilter.toLowerCase()));
                }
        );
    }

    private boolean filterFunction(SalesMan salesMan, String inputSearchNameFilter, SalesMenEnum searchBy) {
        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
        String checkSalesMen = switch (searchBy) {
            case FIRSTNAME -> salesMan.getFirstName().toLowerCase();
            case LASTNAME -> salesMan.getLastName().toLowerCase();
            case EMAIL -> salesMan.getEmail().toLowerCase();
            case SID -> salesMan.getSid().toString().toLowerCase();
            default -> "";
        };

        return checkSalesMen.contains(inputSearchNameFilter);
    }
}
