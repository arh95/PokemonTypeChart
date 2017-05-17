import java.util.*;
//have class for TYPE and have class for MOVE
//TYPE is defensive, how well the pokemon would be able to withstand the hit
//MOVE is offensive, how well the move could do type wise against 
public class Type {
	private String[] typeList = {"Normal","Fire","Fighting","Water","Flying","Grass","Poison","Electric","Ground","Psychic","Rock","Ice","Bug","Dragon","Ghost","Dark","Steel","Fairy"};
	private String whichType;
	boolean strongSet;
	boolean weakSet;
	boolean notSet;
	boolean normSet;
	boolean superSet;
	boolean notVerySet;
	boolean normalSet;
	boolean touchSet;
	private boolean cantAffect;
	private boolean cantTouch;
	private ArrayList <String> Strong;
	private ArrayList <String> Weak;
	private ArrayList <String> Normal;
	private ArrayList <String> NotEffective;
	
	private ArrayList <String> SuperEffective;
	private ArrayList <String> NotVeryEffective;
	private ArrayList <String> NormalEffective;
	private ArrayList <String> Untouchable;
	public Type(){
		//creates dead object
	}
	public Type(String name){
		whichType = name;
		Strong = new ArrayList<String>();
		Normal = new ArrayList<String>();
		Weak = new ArrayList<String>();
		SuperEffective = new ArrayList<String>();
		NotVeryEffective = new ArrayList<String>();
		NormalEffective = new ArrayList<String>();
		setFalse();
	}
	public Type(String name, boolean invincible){
		whichType = name;
		cantAffect = invincible;
		Strong = new ArrayList<String>();
		Normal = new ArrayList<String>();
		Weak = new ArrayList<String>();
		SuperEffective = new ArrayList<String>();
		NotVeryEffective = new ArrayList<String>();
		NormalEffective = new ArrayList<String>();
		if(cantAffect){
			NotEffective = new ArrayList<String>();
		}
		setFalse();
	}
	public Type(boolean untouchable, String name){
		whichType = name;
		cantTouch = untouchable;
		Strong = new ArrayList<String>();
		Normal = new ArrayList<String>();
		Weak = new ArrayList<String>();
		SuperEffective = new ArrayList<String>();
		NotVeryEffective = new ArrayList<String>();
		NormalEffective = new ArrayList<String>();
		if(cantTouch){
			NotEffective = new ArrayList<String>();
		}
		setFalse();
	}
	public Type(String name, boolean invincible, boolean untouchable){
		whichType = name;
		cantAffect = invincible;
		cantTouch = untouchable;
		Strong = new ArrayList<String>();
		Normal = new ArrayList<String>();
		Weak = new ArrayList<String>();
		SuperEffective = new ArrayList<String>();
		NotVeryEffective = new ArrayList<String>();
		NormalEffective = new ArrayList<String>();
		if(cantTouch){
			Untouchable = new ArrayList<String>();
		}
		if(cantAffect){
			NotEffective = new ArrayList<String>();
		}
		setFalse();
	}
	private void setFalse(){
		strongSet = false;
		weakSet = false;
		normSet = false;
		notSet = false;
		superSet = false;
		notVerySet = false;
		normalSet = false;
		touchSet = false;
	}
	public String getType(){
		return whichType;
	}
	public ArrayList <String> getNormal(){
		return Normal;
	}
	public ArrayList <String> getStrong(){
		return Strong;
	}
	public ArrayList <String> getWeak(){
		return Weak;
	}
	public ArrayList <String> getUneffective(){
		return NotEffective;
	}
	public ArrayList <String> getSuperEffective(){
		return SuperEffective;
	}
	public ArrayList <String> getNotVeryEffective(){
		return NotVeryEffective;
	}
	public ArrayList <String> getNormalEffective(){
		return NormalEffective;
	}
	public ArrayList <String> getNotEffective(){
		return Untouchable;
	}
	public boolean getNot(){
		return cantAffect;
	}
	public boolean getCantTouch(){
		return cantTouch;
	}
	public void setStrong(String[] types){
		if(!strongSet){
			for (String s : types){
				Strong.add(s);
			}
			strongSet = true;
		}
		
	}
	public void setWeak(String[] types){
		if(!weakSet){
			for (String s : types){
				Weak.add(s);
			}
			weakSet= true;
		}
	}
	public void setNot(String[] types){
		if(!notSet && cantAffect){
			for (String s : types){
				NotEffective.add(s);
			}
			notSet = true;
		}
	}
	//to run only if strong and weak (and/or noteffective) are already set up
	public void setNormalDef(){
		if(!normSet && weakSet && strongSet){
			for(String type : typeList){
				if(cantAffect){
					if(notSet){
						if(!NotEffective.contains(type) && !Strong.contains(type) && !Weak.contains(type)){
							Normal.add(type);
						}
					}
				} else {
					if (!Strong.contains(type) && !Weak.contains(type)){
						Normal.add(type);
					}
				}
			}
			normSet = true;
		}
	}
	//to run if override desired
	public void setNormalDef(ArrayList <String> types){
		if(!normSet){
			for(String s : types){
				Normal.add(s);
			}
			notSet = true;
		}
	}
	public void setSuper(String[] types){
		if(!superSet){
			for(String s : types){
				SuperEffective.add(s);
			}
			superSet = true;
		}
	}
	public void setNotVery(String[] types){

			if(!notVerySet){
				for(String s : types){
					NotVeryEffective.add(s);
				}
				notVerySet = true;
			}
		
	}

	public void setNotEffective(String[] types){
		if(!touchSet && cantTouch){
			for(String s : types){
				Untouchable.add(s);
			}
			touchSet = true;
		}
	}
	public void setNormalEffective(){
		if(!normalSet && notVerySet && superSet){
			for(String type : typeList){
				if(cantTouch){
					if(touchSet){
						if(!Untouchable.contains(type) && !SuperEffective.contains(type) && !NotVeryEffective.contains(type)){
							NormalEffective.add(type);
						}
					}
				} else {
					if (!SuperEffective.contains(type) && !NotVeryEffective.contains(type)){
						Normal.add(type);
					}
				}
			}
			normSet = true;
		}
	}
	public boolean isSuperEffective(String move){
		if(Weak.contains(move)){
			return true;
		}
		return false;
	}
	
	public boolean isNotVeryEffective(String move){
		if(Strong.contains(move)){
			return true;
		}
		return false;
	}
	public boolean isNotEffective(String move){
		if(!NotEffective.contains(move)){
			return true;
		}
		return false;
	}
}