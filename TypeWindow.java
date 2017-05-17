import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class TypeWindow {
	
	private ArrayList<Type> Typelist;
	
	private JFrame frame;
	private JPanel framePanel;
	private JPanel panel;
	private JPanel togglePanel;
	
	private JPanel AttackSimPanel;
	private JPanel DefenseSimPanel;
	private JPanel TypechartPanel;
	
	private boolean typechartInit;
	private boolean attackSimInit;
	private boolean defenseSimInit;
	
	private ArrayList<JPanel> TypePanels;
	
	private ArrayList<JButton> TypeButtons;
	private JButton offense;
	private JButton defense;
	DefenseListen dListen;
	OffenseListen oListen;
	boolean begun;
	public TypeWindow(){
		
		
	}
	private void clearFrame(){
		
	}
	private void loadInteractive(){
		Typelist = new ArrayList<Type>();
		TypePanels = new ArrayList<JPanel>();
		TypeButtons = new ArrayList<JButton>();
		GridLayout layout = new GridLayout(6,3);
		SwitchListen switchList = new SwitchListen();
		framePanel = new JPanel();
		dListen = new DefenseListen();
		oListen = new OffenseListen();
		togglePanel = new JPanel();
		togglePanel.setLayout(new BoxLayout(togglePanel,BoxLayout.PAGE_AXIS));
		panel = new JPanel();
		panel.setLayout(layout);
		
		offense = new JButton("Attack");
		defense = new JButton("Defense");
		
		offense.addActionListener(switchList);
		defense.addActionListener(switchList);
		
		offense.setHorizontalAlignment(SwingConstants.CENTER);
		defense.setHorizontalAlignment(SwingConstants.CENTER);
		
		togglePanel.add(offense);
		togglePanel.add(defense);
		
		initTypes();
		disableTypes();
		
		begun = false;
		frame = new JFrame("Interactive Typechart");
		framePanel.add(togglePanel);
		framePanel.add(panel);
		frame.add(framePanel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	//initialize type objects, since we need the object's properties to do any work
	private void disableTypes(){
		for (JButton type : TypeButtons){
			type.setEnabled(false);
		}
	}
	private void enableTypes(){
		for (JButton type : TypeButtons){
			type.setEnabled(true);
		}
	}
	private boolean containsItems(String[] types){
		if(types.length == 0){
			return false;
		}
		return true;
	}
	
	private void initTypes(){
		String[] notVery;
		String[] very;
		String[] not;
		String[] super_e;
		String[] notSuper;
		String[] cant;

		//init Normal
		notVery = new String[] {};
		very = new String[] {"Fighting"};
		not = new String[] {"Ghost"};
		super_e = new String[] {};
		notSuper = new String[] {"Rock","Steel"};
		cant = new String[] {"Ghost"};
		makeType("Normal",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Fire
		notVery = new String[] {"Fire","Grass","Ice","Bug","Steel","Fairy"};
		very = new String[] {"Water","Ground","Rock"};
		not = new String[] {};
		super_e = new String[] {"Grass","Ice","Bug","Steel"};
		notSuper = new String[] {"Fire","Water","Rock","Dragon"};
		cant = new String[] {};
		makeType("Fire",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Water
		notVery = new String[] {"Fire","Water","Ice","Steel"};
		very = new String[] {"Grass","Electric"};
		not = new String[] {};
		super_e = new String[] {"Fire","Ground","Rock"};
		notSuper = new String[] {"Water","Grass","Dragon"};
		cant = new String[] {};
		makeType("Water",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Electric
		notVery = new String[] {"Electric","Flying","Steel"};
		very = new String[] {"Ground"};
		not = new String[] {};
		super_e = new String[] {"Water","Flying"};
		notSuper = new String[] {"Electric","Grass","Dragon"};
		cant = new String[] {"Ground"};
		makeType("Electric",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Grass
		notVery = new String[]{"Water","Electric","Grass","Ground"};
		very = new String[] {"Fire","Ice","Poison","Flying","Bug"};
		not = new String[] {};
		super_e = new String[] {"Water","Ground","Rock"};
		notSuper = new String[] {"Fire","Grass","Poison","Flying","Bug","Dragon","Steel"};
		cant = new String[] {};
		makeType("Grass",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Ice
		notVery = new String[] {"Ice"};
		very = new String[] {"Fire","Fighting","Rock","Steel"};
		not = new String[] {};
		super_e = new String[] {"Grass","Ground","Flying","Dragon"};
		notSuper = new String[] {"Fire","Water","Ice","Steel"};
		cant = new String[] {};
		makeType("Ice",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Fighting
		notVery = new String[] {"Bug","Rock","Dark"};
		very = new String[] {"Flying","Psychic","Fairy"};
		not = new String[] {};
		super_e = new String[] {"Normal","Ice","Rock","Dark","Steel"};
		notSuper = new String[] {"Poison","Flying","Psychic","Bug","Fairy"};
		cant = new String[] {"Ghost"};
		makeType("Fighting",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Poison
		notVery = new String[] {"Grass","Fighting","Poison","Bug","Fairy"};
		very = new String[] {"Ground","Psychic"};
		not = new String[] {};
		super_e = new String[] {"Grass","Fairy"};
		notSuper = new String[] {"Poison","Ground","Rock","Ghost"};
		cant = new String[] {"Steel"};
		makeType("Poison",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Ground
		notVery = new String[] {"Poison","Rock"};
		very = new String[] {"Water","Grass","Ice"};
		not = new String[] {"Electric"};
		super_e = new String[] {"Fire","Electric","Poison","Rock","Steel"};
		notSuper = new String[] {"Grass","Bug"};
		cant = new String[] {"Flying"};
		makeType("Ground",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Flying
		notVery = new String[] {"Grass","Fighting","Bug"};
		very = new String[] {"Electric","Ice","Rock"};
		not = new String[] {"Ground"};
		super_e = new String[] {"Grass","Fighting","Bug"};
		notSuper = new String[] {"Electric","Rock","Steel"};
		cant = new String[] {};
		makeType("Flying",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Psychic
		notVery = new String[] {"Fighting","Psychic"};
		very = new String[] {"Bug","Ghost","Dark"};
		not = new String[] {};
		super_e = new String[] {"Fighting","Poison"};
		notSuper = new String[] {"Psychic","Steel"};
		cant = new String[] {"Dark"};
		makeType("Psychic",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Bug
		notVery = new String[] {"Grass","Fighting","Ground"};
		very = new String[] {"Fire","Flying","Rock"};
		not = new String[] {};
		super_e = new String[] {"Grass","Psychic","Dark"};
		notSuper = new String[] {"Fire","Fighting","Poison","Flying","Ghost","Steel","Fairy"};
		cant = new String[] {};
		makeType("Bug",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Rock
		notVery = new String[] {"Normal","Fire","Poison","Flying"};
		very = new String[] {"Water","Grass","Fighting","Ground","Steel"};
		not = new String[] {};
		super_e = new String[] {"Fire","Ice","Flying","Bug"};
		notSuper = new String[] {"Fighting","Ground","Steel"};
		cant = new String[] {};
		makeType("Rock",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Ghost
		notVery = new String[] {"Poison","Bug"};
		very = new String[] {"Ghost","Dark"};
		not = new String[] {"Normal","Fighting"};
		super_e = new String[] {"Psychic","Ghost"};
		notSuper = new String[] {"Dark"};
		cant = new String[] {"Normal"};
		makeType("Ghost",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Dragon
		notVery = new String[] {"Fire","Water","Electric","Grass"};
		very = new String[] {"Ice","Dragon","Fairy"};
		not = new String[] {};
		super_e = new String[] {"Dragon"};
		notSuper = new String[] {"Steel"};
		cant = new String[] {"Fairy"};
		makeType("Dragon",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Dark
		notVery = new String[] {"Ghost","Dark"};
		very = new String[] {"Fighting","Bug","Fairy"};
		not = new String[] {"Psychic"};
		super_e = new String[] {"Psychic","Ghost"};
		notSuper = new String[] {"Fighting","Dark","Fairy"};
		cant = new String[] {};
		makeType("Dark",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Steel
		notVery = new String[] {"Normal","Grass","Ice","Flying","Psychic","Bug","Rock","Dragon","Steel","Fairy"};
		very = new String[] {"Fire","Fighting","Ground"};
		not = new String[] {"Poison"};
		super_e = new String[] {"Ice","Rock","Fairy"};
		notSuper = new String[] {"Fire","Water","Electric","Steel"};
		cant = new String[] {};
		makeType("Steel",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
		//init Fairy
		notVery = new String[] {"Fighting","Bug","Dark"};
		very = new String[] {"Poison","Steel"};
		not = new String[] {"Dragon"};
		super_e = new String[] {"Fighting","Dark","Dragon"};
		notSuper = new String[] {"Fire","Poison","Steel"};
		cant = new String[] {};
		makeType("Fairy",notVery,very,not,super_e,notSuper,cant,containsItems(not),containsItems(cant));
	}

		//initialize type information such as strengths and weaknesses, and also 
		//add a button for the type to the frame
	private void makeType(String name, String[] notVery, String[] very, String[] not,String[] super_e,String[] notSuper,String[] cant,boolean invincible,boolean invulnerable){
		
		Type newType = new Type(name,invincible,invulnerable);
		newType.setStrong(notVery);
		newType.setWeak(very);
		if(invincible){
			newType.setNot(not);
		}
		
		newType.setSuper(super_e);
		newType.setNotVery(notSuper);
		if(invulnerable){
			newType.setNotEffective(cant);
		}
		Typelist.add(newType);
		
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new BoxLayout(newPanel,BoxLayout.PAGE_AXIS));
		JButton newButton = new JButton(name);
		newButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		newPanel.add(newButton);
		panel.add(newPanel);
		
		TypePanels.add(newPanel);
		TypeButtons.add(newButton);
	}
	private void replaceListeners(boolean isAttack){
		
		for (JButton button : TypeButtons){
			for(ActionListener old : button.getActionListeners()){
				button.removeActionListener(old);
				
			}
			if(isAttack){
				button.addActionListener(oListen);
			} else {
				button.addActionListener(dListen);
			}
		}
	}
	class SwitchListen implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String source = e.getActionCommand();
			if(source.equals("Attack")){
				replaceListeners(true);
				offense.setEnabled(false);
				defense.setEnabled(true);
			} else if (source.equals("Defense")){
				replaceListeners(false);
				defense.setEnabled(false);
				offense.setEnabled(true);
			}
			if(!begun){
				begun = true;
				enableTypes();
			}
		}
	}
	class DefenseListen implements ActionListener{
		public void actionPerformed(ActionEvent e){

			String type = e.getActionCommand();
			Type holder = new Type();
			for (Type x : Typelist){
				if(type.equals(x.getType())){
					holder = x;
					break;
				}
			}
			String message = "";
			ArrayList<String> temp = new ArrayList<String>();
			temp = holder.getStrong();
			if(!temp.isEmpty()){
				String strong = "Resistant to:\t";
				for (String type1 : holder.getStrong()){
					strong += type1 + ", ";
				}
			
				strong = strong.substring(0,strong.length() - 2);
				message += strong + "\n";
			}
			temp = holder.getWeak();
			if(!temp.isEmpty()){
				String weak = "Weak against: \t";
				for (String type2 : holder.getWeak()){
					weak += type2 + ", ";
				}
				weak = weak.substring(0,weak.length() - 2);
				message += weak + "\n";
			}
			if(holder.getNot()){
				String invincible = "Not affected by:\t";
				for (String type3 : holder.getUneffective()){
					invincible += type3 + ", ";
				}
				invincible = invincible.substring(0,invincible.length() - 2);
				message += invincible + "\n";
			}
			JOptionPane.showMessageDialog(null,message);
			
			
		}
	}
	class OffenseListen implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String type = e.getActionCommand();
				Type holder = new Type();
				for (Type x : Typelist){
					if(type.equals(x.getType())){
						holder = x;
						break;
					}
				}
				String message = "";
				ArrayList<String> temp = new ArrayList<String>();
				temp = holder.getSuperEffective();
				if(!temp.isEmpty()){
					String strong = "Super effective against:\t";
					for (String type1 : temp){
						strong += type1 + ", ";
					}
					strong = strong.substring(0,strong.length() - 2);
					message += strong + "\n";
				}
				String weak = "Not very effective against:\t";
				temp = holder.getNotVeryEffective();
				if(!temp.isEmpty()){
					for (String type2 : temp){
						weak += type2 + ", ";
					}
					weak = weak.substring(0,weak.length() - 2);
					message += weak + "\n";
				}
				if(holder.getCantTouch()){
					String invincible = "Can't affect:\t";
					for (String type3 : holder.getNotEffective()){
						invincible += type3 + ", ";
					}
					invincible = invincible.substring(0,invincible.length() - 2);
					message += invincible + "\n";
				}
				JOptionPane.showMessageDialog(null,message);
			
			
			}
		}
		//back button to be able to traverse screens
		class BackListen implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
	
	
	
	
	
	
}