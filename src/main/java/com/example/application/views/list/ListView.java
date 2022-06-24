package com.example.application.views.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("list")
@Route(value = "")
public class ListView extends VerticalLayout {

    public ListView() {
        NumberField wzrost = new NumberField();
        wzrost.setLabel("wzrost");
        wzrost.setValue(0.00);
        Div znak = new Div();
        znak.setText("m");
        wzrost.setPrefixComponent(znak);


        NumberField waga = new NumberField();
        waga.setLabel("waga");
        waga.setValue(0.00);
        Div znak1 = new Div();
        znak1.setText("kg");
        waga.setPrefixComponent(znak1);

        Button oblicz = new Button("Oblicz BMI");

        Span niedowaga = new Span("<18,5 = Niedowaga");
        niedowaga.getElement().getThemeList().add("badge");

        Span norma = new Span("18,5 - 24,99 = Norma");
        norma.getElement().getThemeList().add("badge success");

        Span nadwaga = new Span("25 - 29,99 = Nadwaga");
        nadwaga.getElement().getThemeList().add("badge error");

        Span otylosc = new Span(">29,99 = otyłość");
        otylosc.getElement().getThemeList().add("badge contrast");


        oblicz.addClickListener(click-> Notification.show("Twoje BMI wynosi: " + waga.getValue()/Math.pow(wzrost.getValue(), 2.0)));

        add(wzrost, waga, oblicz, niedowaga, norma, nadwaga, otylosc);
    }

}
