##I/O相关

- File，最基本的io类，它其实既能一个文件，又能代表一个目录。  
如果是目录，可以调用list()显示文件列表。list()有个可以加过滤器的重载方法list(FilenameFilter filter) 。创建自己的过滤器类：
	
		class DirFilter implements FilenameFilter
		{
		    private Pattern pattern;
		
		    public DirFilter(String regex)
		    {
		        this.pattern = Pattern.compile(regex);
		    }
		
		    @Override
		    public boolean accept(File paramFile, String paramString)
		    {
		        Matcher m = pattern.matcher(paramString);
		        return m.matches();
		    }
		
		}


- FilterInputStream和FilterOutputStream是用来提供装饰器类接口，以控制特定输入流和输出流的两个类。

- InputStream和OutputStream是面向字节的流，而Reader和Writer是面向字符的类。二者可通过InputStreamReader()和OutputStreamWriter()转换。  
Reader和Writer可以处理16位的Unicode字符，InputStream和OutputStream只能处理8位的字节。

- 明智的做法是尽量选择Reader和Writer，如果发现编译不过，只能用InputStream和OutputStream，如java.util.zip只能是面向字节的

- 压缩  
压缩类属于InputStream和OutputStream,因为压缩类是面向字节处理的。  
DeflaterOutputStream：压缩基类  
ZipOutputStream：压缩成zip文件  
GZIPOutputStream：压缩成GZIP格式  
InflaterInputStream：解压缩基类  
ZipInputStream：解压缩zip文件  
GZIPInputStream：解压缩GZIP格式   
CheckedInputStream:  为InputStream产生校验和  
CheckedOutputStream:为OutputStream产生校验和  

zip格式也可以用于jar文件

- 序列化  
序列化的意思是将对象转换成一个字节序列，可以恢复成原来的对象。跨平台。可以称为一种轻量级的持久性。  
序列化的特性在java中主要为了支持两种特性： 
	1. java远程方法调用RMI
	2. 对java bean的使用。通常会对bean进行传递或者恢复。  	  

要序列化一个对象，首先创建某种OutputStream对象，然后将他包装到ObjectOutputStream对象中，调用writeObject()方法即可。  
反序列化一个对象，首先创建某种InputStream对象，然后将他包装到ObjectInputStream对象中，调用readObject()方法即可。得到的是个Object类型对象，要向下转型。  

- 序列化过程的特殊控制  
要对序列化过程进行特殊控制，一种办法是用Externalizable代替Serializable接口。Externalizable继承了Serializable接口。通过writeExternal()和readExternal()方法实现对序列化过程的控制。这两个方法是在序列化和反序列化的过程中自动调用的。  
必须注意的是：Serializable的序列化中，对象完全是以二进制序列来存储，不需要构造器的参与。而Externalizable是先调用默认构造器，在调用writeExternal()或者readExternal()方法，所以必须提供公共的默认构造器。然后在writeExternal()或者readExternal()中对需要序列化的字段进行显式的操作。这比较麻烦。  
另一种办法是对敏感字段用transient修饰。瞬态。  
还有一个办法，在实现了Serializable接口的类中，添加两个方法：
> private void writeObject(ObjectOutputStream stream) 
throws IOException; 

> private void readObject(ObjectlnputStream stream) 
throws IOException, ClassNotFoundException 

注意：方法签名必须这样写，这是java序列化神奇也可以说混乱的一点。方法是private的，不是接口的一部分。在序列化或反序列化的时候，序列化机制会检测类是否有自己的writeObject()和readObject()方法，有就调用自己的。


- XML  
解析xml可以使用java自带的javax.xml.*类库，也可以使用开源的XOM类库。去http://www.xom.nu/下载doc和jar包。  
现在一般用DOM4J。解析XML的方法很多。

- Preferences  偏好设置  
存储key-value对。    
只能存储基本类型和字符串。  
可以选用userNodeForPackage或者systemNodeForPackage        
> Preferences prefs = Preferences.userNodeForPackage(PreferenceDemo.class);

或者
>  Preferences.systemNodeForPackage(PreferenceDemo.class);

然后使用这种put，get方法进行存值和取值
		
		prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys())
            System.out.println(key + ": " + prefs.get(key, null));


神奇的地方是，运行程序看不到生成任何的文件，那这些数据到底存到哪里了？原来java会根据系统的不同，存到合适的系统资源中，比如windows就存到注册表中。
