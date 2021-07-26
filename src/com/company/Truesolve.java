package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Truesolve extends JFrame {
    // Модель списка
    private DefaultListModel<String> dlm = new DefaultListModel<String>();
    JList<String> list1;
    JList<String> list2;

    private final String[] data1 = {"Ручка", "Привод поршня", "Гайка", "Шайба", "Фланец", "Клапан", "Штуцер", "Сальник"};
    private final String[] data2 = {"Дерево", "Металл"};

    public Truesolve() {
        super("Завод");
        Random random = new Random();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Создание панели
        JPanel contents = new JPanel();

        // Наполнение модели данными
        for (String string : data2) {
            dlm.add(0, string);
        }
        // Создание кнопки
        JButton add = new JButton("Сделать");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Model model = new Model();
                model.setMaterial(list2.getSelectedValue());
                model.setName(list1.getSelectedValue());
                model.setPrice(random.nextInt(200));
                model.setWeight(random.nextInt(20));
                System.out.println(model.toString());
            }
        });
        list1 = new JList<String>(data1);
        list2 = new JList<String>(dlm);

        // Размещение компонентов в панели
        contents.add(add);
        contents.add(new JScrollPane(list1));
        contents.add(new JScrollPane(list2));


        setContentPane(contents);
        // Вывод окна
        setSize(400, 200);
        setVisible(true);
    }
}
