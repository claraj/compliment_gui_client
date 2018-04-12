package compliments;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by clara on 4/12/18.
 */
public class ComplimentGUI extends JFrame {
    private JButton getCompliment;
    private JLabel complimentText;
    private JPanel mainPanel;
    
    ComplimentGUI() {
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        getCompliment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String compliment = ComplimentClient.getCompliment();
                complimentText.setText(compliment);
        
            }
        });
        
    }
    
    
}
