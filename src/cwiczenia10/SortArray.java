package cwiczenia10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.IO.println;

public class SortArray extends JFrame {
    JLabel etykietaWielkoscTablicy;
    JTextField poleDlugoscTablicy;
    JButton przyciskWczytajTablice;
    JButton przyciskSortujTablice;
    JLabel etykietaWypiszTablice;
    JTextArea areaWypiszTablice;
    JLabel etykietaPosortowanaTablica;
    JTextArea areaWypiszPosortowanaTablice;
    Font czcionkaEtykiet;
    Font czcionkaPrzyciskow;
    List<Integer> liczby = new ArrayList<>();

    public SortArray() {
        setTitle("Sort Array");
        setIconImage(new ImageIcon("src/strawberry.png").getImage());
        setSize(new Dimension(600,800));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        czcionkaEtykiet = new Font("Arial",Font.PLAIN,23);
        czcionkaPrzyciskow = new Font("Arial",Font.PLAIN,16);

        etykietaWielkoscTablicy = new JLabel("Podaj rozmiar tablicy:");
        etykietaWielkoscTablicy.setSize(150,50);
        etykietaWielkoscTablicy.setBackground(Color.pink);
        etykietaWielkoscTablicy.setOpaque(true); // Ustawiamy etykietę jako nieprzezroczystą
        etykietaWielkoscTablicy.setFont(czcionkaEtykiet);

        poleDlugoscTablicy = new JTextField("999");
        poleDlugoscTablicy.setFont(czcionkaEtykiet);
        poleDlugoscTablicy.setHorizontalAlignment(JTextField.CENTER);
        poleDlugoscTablicy.setPreferredSize(new Dimension(100,50));
        poleDlugoscTablicy.setFocusable(true);

        przyciskWczytajTablice = new JButton("Wyświetl tablicę:");
        przyciskWczytajTablice.setFont(czcionkaPrzyciskow);
        przyciskWczytajTablice.setPreferredSize(new Dimension(200,50));

        przyciskWczytajTablice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dlTablicy = poleDlugoscTablicy.getText();
                int dlugoscTablicy = Integer.parseInt(dlTablicy);
                Random random = new Random();
                for (int i = 0; i < dlugoscTablicy; i++) {
                    liczby.add(random.nextInt(9,99)+1);
                }
                println("Liczby: "+ liczby);
                areaWypiszTablice.setText(liczby.toString());
            }
        });

        przyciskSortujTablice = new JButton("Sortuj i wyświetl tablicę:");
        przyciskSortujTablice.setFont(czcionkaPrzyciskow);
        przyciskSortujTablice.setPreferredSize(new Dimension(200,50));

        przyciskSortujTablice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(liczby);
                for (Integer i: liczby) areaWypiszPosortowanaTablice.append(i+" ");
            }
        });

        etykietaWypiszTablice = new JLabel("Tablica przed sortowaniem:");
        etykietaWypiszTablice.setFont(czcionkaEtykiet);
        areaWypiszTablice = new JTextArea(15,45);
        areaWypiszTablice.setLineWrap(true);
        areaWypiszTablice.setWrapStyleWord(true);

        etykietaPosortowanaTablica = new JLabel("Tablica po sortowaniu:");
        etykietaPosortowanaTablica.setFont(czcionkaEtykiet);

        areaWypiszPosortowanaTablice = new JTextArea(15,45);
        areaWypiszPosortowanaTablice.setLineWrap(true);
        areaWypiszPosortowanaTablice.setWrapStyleWord(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#eab676"));
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(etykietaWielkoscTablicy);
        mainPanel.add(poleDlugoscTablicy);

        JSeparator jSeparator = new JSeparator(JSeparator.HORIZONTAL);
        jSeparator.setPreferredSize(new Dimension(600,2));
        mainPanel.add(jSeparator);

        mainPanel.add(etykietaWypiszTablice);
        JScrollPane jScrollPane = new JScrollPane(areaWypiszTablice);
        jScrollPane.setHorizontalScrollBar(new JScrollBar(Adjustable.HORIZONTAL));
        mainPanel.add(jScrollPane);
        mainPanel.add(przyciskWczytajTablice);

        JSeparator jSeparator2 = new JSeparator(JSeparator.HORIZONTAL);
        jSeparator2.setPreferredSize(new Dimension(600,2));
        mainPanel.add(jSeparator2);
        mainPanel.add(etykietaPosortowanaTablica);

        JScrollPane scrollPane = new JScrollPane(areaWypiszPosortowanaTablice);
        scrollPane.setHorizontalScrollBar(new JScrollBar(SwingConstants.HORIZONTAL));

        mainPanel.add(scrollPane);
        mainPanel.add(przyciskSortujTablice);

        add(mainPanel);
    }

    void main() {
        SwingUtilities.invokeLater(()->new SortArray().setVisible(true));
    }
}
