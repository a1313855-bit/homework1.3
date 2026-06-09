interface BookStyle5{
	String book(String name,double price);
}
class Ex5{
	public static void main(String[] args) {
		//宣告BookStyle5 a1 = new BookStyle5(){Cal內的b1方法}
		BookStyle5 a1=Cal::b1;
		//宣告BookStyle5 a1 = new BookStyle5(){Cal內的b1方法}
		BookStyle5 a2=Cal::b2;
		//宣告BookStyle5 a1 = new BookStyle5(){Cal內的b1方法}
		BookStyle5 a3=Cal::b3;
		//輸出
		System.out.println(a1.book("java",2000));
		//java 書名:java 價格:2000*0.9
		System.out.println(a2.book("java",2000));
		//java練習 書名:java 價格:2000*0.8
		System.out.println(a3.book("java",2000));
		//java 書名:java 價格:2000*0.9 (if後的結果)

		//Array 應用
		//宣告BookStyle5 陣列內 物件數量
		BookStyle5[] b=new BookStyle5[3];
		//宣告b[0]物件=new BookStyle5(){Cal內的b1方法}
		b[0]=Cal::b1;
		//宣告b[1]物件=new BookStyle5(){Cal內的b2方法}
		b[1]=Cal::b2;
		//宣告b[2]物件=new BookStyle5(){Cal內的b3方法}
		b[2]=Cal::b3;
		//利用for-each 把b[0],b[1],b[2]，依序叫出來
		for(BookStyle5 o:b){
			//將interface的book方法帶入引數 for-each把b物件裡的所有方法套上
			System.out.println(o.book("java",2000));
			//b[0]->java 書名:java 價格:2000*0.9
			//b[1]->java練習 書名:java 價格:2000*0.8
			//b[2]->java 書名:java 價格:2000*0.9 (if後的結果)
		}
	}
}

class Cal{
	/*
	1.interface 方法權限public 這裡方法要使用所以也要是public
	2.加上static 因為這邊沒有要new Cal class
	3.datatype要和interface方法相同
	4.方法名稱跟interface方法名稱"不"同
	5.引數() 必須要跟interface 方法引數相同
	*/
	public static String b1(String name,double price){
		return "java 書名:"+name+"\t價格:"+price*0.9;
	}
	public static String b2(String name,double price){
		return "java練習 書名:"+name+"\t價格:"+price*0.8;
	}
	public static String b3(String name,double price){
		String show=null;
		if(price>=2000){
				show="java 書名:"+name+"\t價格:"+price*0.9;
			}else if(price>=1500){
				show="java 書名:"+name+"\t價格:"+price*0.95;
			}else{
				show="java 書名:"+name+"\t價格:"+price;
			}
			return show;
	}
}