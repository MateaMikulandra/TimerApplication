package main;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;

class Tajmer  {

    public static void main(String[] args){
        
       
        
                PopupMenu pum = new PopupMenu();
	MenuItem miSettings = new MenuItem("Settings");
        MenuItem miClose = new MenuItem("Close");
        
        miClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
        
        miSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings s = new Settings();
                s.setVisible(true);
            }
        });
        
        
        pum.add(miSettings);
				pum.add(miClose);

				SystemTray st = SystemTray.getSystemTray();

				try {
					Image img = ImageIO.read(new File("tajmer.png"));
					TrayIcon myTray = new TrayIcon(img);
					myTray.setPopupMenu(pum);
					myTray.setImageAutoSize(true);
					myTray.setToolTip("Klikni");
					st.add(myTray);

				} catch (Exception ex) {

				} 
                
                
            }
       

}
