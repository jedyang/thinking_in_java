## 字符串

- 字符串的方法中，当涉及修改字符串内容时，String的方法总是返回一个新的String对象，如果内容没有改变，则返回原对象。这样可以节约存储空间以及避免额外的开销。

- java中，```\\```表示我要插入一个正则表达式的反斜线，所以其后的字符有特殊意义，所以想插入一个普通的反斜线要用```\\\\```  
不过换行或者制表符之类的只需要用一个反斜线```\n \t```

- String的matches()，split()，replaceFirst(),replaceAll()可以用正则。  

- 量词。一般我们用的正则都是贪婪型的。如X+，X？。如果在贪婪型后面再加和？，即变成X+？，X？？这种就是非贪婪性，也加勉强行。望文知意。  
java里面还有一种特殊的，在贪婪型后面加个+，不保存中间状态。

- 功能更强大的正则对象使用。 
 
		Pattern p = Pattern.compile(正则string);
	    Matcher m = p.matcher(要匹配的string);
	
	    while (m.find())
	    {
	        System.out.println("match :" + m.group() + " at " + m.start()
	                + "-" + m.end());
	    }
find()查找部分是否匹配  
maches（）查看整个str是否匹配  
appendReplacement（）提供了渐进式替换  
reset（）方法将matcher对象应用到一个新的字符序列  

- Scanner类用于处理扫描输入
