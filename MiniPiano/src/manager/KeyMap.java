package manager;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {
	private Map<Object, Object> map;	//键盘键值-面板组件序号对应表
	private Map<Object, Object> smap;	//键盘键值-符号对应表
	@SuppressWarnings("unused")
	private Map<Object,Object> blackmap;	//黑键对应表
	@SuppressWarnings("unused")
	private Map<Object,Object> whitemap;	//白键对应表
	@SuppressWarnings("unused")
	private int black[]= {	//黑键所对应的键值
			49,50,51,52,53,54,55,56,57,48,45,61,155,36,81,87,
			69,82,84,89,85,73,79,80,91,93,92,127,65,83,68,70,71,72,74,75,
			76,59,222,44,46,47,77,32,97,98,99,100,101,102,103,107
			
	};
	private static int whitenums=52;	//白键数量
	private static int blacknums=36;	//黑键数量
	//存放顺序为先放白键后放黑键
	@SuppressWarnings("unused")
	private int white[]= {	//白键所对应的键值
			78,66,
			86,67,88,90,104,105,111,106,109,37,40,39,96,110,38,35,34,33,19,
			8,123,122,121,120,119,118,117,116,115,114,113,112,192,20
	};
	private int key[]= {	//按钮对应的键值
			49,50,51,52,53,54,55,56,57,48,45,61,155,36,81,87,
			69,82,84,89,85,73,79,80,91,93,92,127,65,83,68,70,71,72,74,75,
			76,59,222,44,46,47,77,32,97,98,99,100,101,102,103,107,78,66,
			86,67,88,90,104,105,111,106,109,37,40,39,96,110,38,35,34,33,19,
			8,123,122,121,120,119,118,117,116,115,114,113,112,192,20
	};
	private String press[]= {		//对应键盘上的按钮
			"1","2","3","4","5","6","7","8","9","0","-","=","insert","home",
			"Q","W","E","R","T","Y","U","I","O","P","[","]","\\","delete",
			"A","S","D","F","G","H","J","K","L",";","'",",",".","/",
			"M","SPACE","NUM1","NUM2","NUM3","NUM4","NUM5","NUM6","NUM7",
			"NUM+","N","B","V","C","X","Z","NUM8","NUM9","NUM/","NUM*","NUM-",
			"←","↓","→","NUM0","NUM.","↑","end","pagedown","pageup","Pause",
			"Backspace","F12","F11","F10","F9","F8","F7","F6","F5","F4","F3",
			"F2","F1","~","CAPSLOCK"
	};
	private int value[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
			19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,
			39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,
			60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,
			81,82,83,84,85,86,87};		//按钮在面板中按顺序实例化的组建序号
	public KeyMap(){
		this.map=new HashMap<>();
		this.smap=new HashMap<>();
		for(int i=0;i<key.length;i++) {		
			map.put(key[i], value[i]);		//将键盘键值和按钮组件对应
			smap.put(key[i], press[i]);		//将键盘键值和键盘符号对应
		}
	}
	public Object mapget(int key) {			//得到键值对应的面板组件序号
		 return map.get(key);
	}
	public boolean mapcount(int key) {		//判断该键值是否存在对应的面板组件序号
		return map.containsKey(key);
	}
	public Object smapget(int key) {	   //得到键值对应的符号
		 return smap.get(key);
	}
	public boolean smapcount(int key) {	  //判断该键值是否存在对应符号
		return smap.containsKey(key);
	}
	public int getBlackNums() {				//得到黑键数目
		return blacknums;
	}
	public int getWhiteNums() {				//得到白键数目
		return whitenums;
	}
}
