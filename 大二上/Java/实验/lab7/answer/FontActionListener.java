package cn.edu.zjut.java.exp06;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class FontActionListener implements ActionListener{

	NotePadWithFileFunction p = null;
	public  FontActionListener(NotePadWithFileFunction parent) {
		
		this.p = parent;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		

		//JColorChooser colorChooser=new JColorChooser();
		//Color color= colorChooser.showDialog(null, "字体颜色", Color.BLACK);
		
		FontChooser fc = new FontChooser(p, "字体选择", p.df);//阻塞
		fc.setVisible(true);
		
		//System.out.println("test");
		
		p.ta.setFont(new Font(p.df.font,Font.PLAIN,p.df.fontSize));
		p.ta.setForeground(NotePadWithFileFunction.selectedColor);
		
	}

}
