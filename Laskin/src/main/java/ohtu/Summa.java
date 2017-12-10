
package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int tulosennensuoritusta;
    
    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta){
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    } 
    
    @Override
    public void suorita() {
        tulosennensuoritusta = sovellus.tulos();
        
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        sovellus.plus(arvo);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(tulosennensuoritusta);
        
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
