## 内部类

注意：以下内部类指非静态内部类。静态内部类称为嵌套类。

- 内部类可以访问外部类的所有成员，注意是所有。因为要生成内部类实例必须通过其外部类实例，这样在生成内部类实例时，是默默的获取到了外部类的实例，所以内部类实例可以访问外部类实例的所有成员。

- 外部类无法访问内部类的任何成员。

- 在内部类中不能声明静态成员。  
  嵌套类中都可以声明。

- 在方法或作用域中定义内部类，称为局部内部类。局部内部类可以访问代码块内的常量，和外部类的所有成员。

- 创建嵌套类不需要外部类实例，所以嵌套类也就不可以访问外部类的非静态成员。

- 没有静态类这种东西，只有内部类可以被声明为静态的。

- 嵌套类可以作为接口的一部分。放在接口中的类自动就是public和static的。接口中不能放任何代码实现，但是如果想要编写供所有实现该接口的类可公用的代码，内部类是个好主意。

- 为什么要有内部类？内部类使java的多继承体系得以完整。我们知道java只允许单继承类。那么如果真的必须多继承怎么办？可以用内部类，内部类可以继承，而且内部类可以访问外部类的所有成员，通道是畅通的。

- 闭包是指一个可调用的对象，它记录了一些信息，这些信息来自于创建它的作用域。这样来看，内部类就是一种闭包，它包含创建它的外部类的信息。
所以可以通过内部类回调外部类。

		package thinkinjava.chapter10;
		
		interface Incrementable
		{
		    void increment();
		}
		
		// Very simple to just implement the interface:
		class Callee1 implements Incrementable
		{
		    private int i = 0;
		
		    @Override
		    public void increment()
		    {
		        i++;
		        System.out.println(("callee1:"+i));
		    }
		}
		
		class MyIncrement
		{
		    public void increment()
		    {
		        System.out.println(("Other operation"));
		    }
		
		    static void f(MyIncrement mi)
		    {
		        mi.increment();
		    }
		}
		
		//MyIncrement里面的increment与接口的increment冲突，这种情况下只能用内部类了
		class Callee2 extends MyIncrement
		{
		    private int i = 0;
		
		    @Override
		    public void increment()
		    {
		        super.increment();
		        i++;
		        System.out.println("callee2:"+i);
		    }
		
		    private class Closure implements Incrementable
		    {
		        @Override
		        public void increment()
		        {
		            // 调外部类的方法之前可以加点逻辑
		            // 安全的回调，我只允许你调这个方法。
		            System.out.println("内部类回调");
		            Callee2.this.increment();
		        }
		    }
		
		    Incrementable getCallbackReference()
		    {
		        return new Closure();
		    }
		}
		
		class Caller
		{
		    private Incrementable callbackReference;
		
		    Caller(Incrementable cbh)
		    {
		        callbackReference = cbh;
		    }
		
		    void go()
		    {
		        callbackReference.increment();
		    }
		}
		
		public class CallBacks
		{
		    public static void main(String[] args)
		    {
		        Callee1 c1 = new Callee1();
		        Callee2 c2 = new Callee2();
		        MyIncrement.f(c2);
		        Caller caller1 = new Caller(c1);
		        Caller caller2 = new Caller(c2.getCallbackReference());
		        caller1.go();
		        caller2.go();
		    }
		}


- 内部类的继承。因为内部类必须要获取外部类，所以构造器必须要入参一个外部类。否则编译报错。

		package thinkinjava.chapter10;
		
		public class InnerExtend extends Outer.Inner
		{
		    InnerExtend(Outer out)
		    {
		        out.super();
		    }
		}
		
		class Outer
		{
		    class Inner
		    {
		
		    }
		}

