## 泛型

### 擦除
- java的泛型是通过擦除来实现的。就是说在使用泛型时，任何具体的类型信息都被擦出了，唯一知道的就是在使用一个对象。因此List<String>和List<Integer>在运行时事实上是相同的类型。，这两种List都被擦除为他们的原生类型List。  

        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();

        System.out.println(c1 == c2);
		// true


- <? extends T> 表示类型的上界，表示参数化类型的可能是T 或是 T的子类  
  <? super T> 表示类型下界（Java Core中叫超类型限定），表示参数化类型是此类型的超类型（父类型），直至Object  
  换成白话是这个意思：  
List<? extends T> 是说 这个list放的是T或者T的子类型的对象，但是不能确定具体是什么类型，所以可以get（），不能add（）（可以add null值）  
List<? super T> 是说这个list放的是至少是T类型的对象，所以我可以add T或者T的子类型，但是get得到的类型不确定，所以不能get


引用下网上遍地的例子

	   //extends 示例
    static class Food
    {
    }

    static class Fruit extends Food
    {
    }

    static class Apple extends Fruit
    {
    }

    static class RedApple extends Apple
    {
    }

    public static void main(String[] args)
    {

        List<? extends Fruit> flist = new ArrayList<Apple>();
        // complie error:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // only work for null
        //List<? extends Frut> 表示 “具有任何从Fruit继承类型的列表”，编译器无法确定List所持有的类型，所以无法安全的向其中添加对象。因为这个list可能放的是apple，你却要往里放orange。可以添加null,因为null 可以表示任何类型。所以List 的add 方法不能添加任何有意义的元素，但是可以接受现有的子类型List<Apple> 赋值。
        Fruit fruit = flist.get(0);
        Apple apple = (Apple) flist.get(0);
        //由于，其中放置是从Fruit中继承的类型，所以可以安全地取出Fruit类型。
        flist.contains(new Fruit());
        flist.contains(new Apple());
        //在使用Collection中的contains 方法时，接受Object 参数类型，可以不涉及任何通配符，编译器也允许这么调用。
        //super 示例
        List<? super Fruit> flist2 = new ArrayList<Fruit>();
        flist2.add(new Fruit());
        flist2.add(new Apple());
        flist2.add(new RedApple());

        // compile error:
        //List<? super Fruit> flist3 = new ArrayList<Apple>();
        //List<? super Fruit> 表示“具有任何Fruit超类型的列表”，列表的类型至少是一个 Fruit 类型，因此可以安全的向其中添加Fruit 及其子类型。由于List<? super Fruit>中的类型可能是任何Fruit 的超类型，无法赋值为Fruit的子类型Apple的List<Apple>.
        // compile error:
        //    Fruit item = flist3.get(0);
        //因为，List<? super Fruit>中的类型可能是任何Fruit 的超类型，所以编译器无法确定get返回的对象类型是Fruit,还是Fruit的父类Food 或 Object.
    }
extends 可用于的返回类型限定，不能用于参数类型限定。
super 可用于参数类型限定，不能用于返回类型限定。
>带有super超类型限定的通配符可以向泛型对易用写入，带有extends子类型限定的通配符可以向泛型对象读取。


- 在泛型中使用super/extends，擦除时会擦出到边界。未指定边界的被擦除为Object。

- 因为擦除，在写泛型代码的时候必须时刻提醒自己，你只是看起来好像拥有有关参数的类型信息而已，好像所有的泛型T都被你的具体参数类型替换掉了，但其实，它只是一个Object。

### 通配符 ？

- 对于数组：

	    class Fruit {} 
		class Apple extends Fruit {} 
		class Jonathan extends Apple {} 
		class Orange extends Fruit {} 
		public class CovariantArrays { 
		public static void main(String[] args) { 
		Fruit[] fruit = new Apple[10]; 
		fruit[0] = new Apple(); // OK 
		fruit[1] = new Jonathan(); // OK 
		// Runtime type is Apple[], not Fruit[] or Orange[]: 
		try { 
		// Compiler allows you to add Fruit: 
		fruit[0] = new Fruit(); // ArrayStoreException 
		} catch(Exception e) { System.out.println(e); } 
		try { 
		// Compiler allows you to add Oranges: 
		fruit[0] = new Orange(); // ArrayStoreException 
		} catch(Exception e) { System.out.println(e); } 
		} 
		}
你可以创建一个子类数组，将其赋值给父类数组。在编译器向其添加不是该子类的其他类型，编译器不会报错，运行期会报错。

但是对于容器，```List<Fruit> flist = new ArrayList<Apple>(); ``` 这种语句直接编译期报错，因为List<Apple>和List<Fruit>之间没有任何继承关系，他们完全是不同的东西。

- 无界通配符<?>

### 注意点

- 不能使用基本类型作为泛型的类型参数。一般的替代方法是使用包装类型。只有当包装类型的转换成为性能瓶颈时，可以考虑使用专门适配基本类型的容器版本：org.apache.commons.collections.primitives。

- 一个类不能同时实现同一个泛型接口的两种变体。因为擦除的原因，这两个变体接口，会变成同一个，编译不过的。
