## 持有对象

- 使用```Arrays.asList()```作为List来用时，因为其底层仍然是数组，因此不能调整尺寸。所以调用add()或者delete()方法会运行时报错。

- map的存储顺序：hashmap根据hash值存储，和输入顺序无关。treemap根据比较结果，升序存储键。linkedhashmap根据插入顺序保存，同时还保持了hash的查找速度。

- List：arraylist，插入和移除较慢，查找快。linkedlist：查找慢，但是插入和移除快。另外linkedlist比arraylist的可用方法多。

- ListIterator是Iterator的子类型，用于在List中移动。（Iterator用于在Collection中移动）。ListIterator可以双向移动。他可以得到前一个和后一个的引用。

- LinkedList，getFirst(),element(),peek()都是获取第一个元素，区别是peek()面对空列表不会报运行时异常。  
remove()，removeFirst()，poll()都是移除最前面的一个元素，区别也是poll()面对空列表不会运行时报错。    
add(),offer(),addlast()都是在后面加一个元素  
addFirst()在前面加一个元素  
removeLast（） 移除最后一个

- 可以用linkedlist来构建的stack  
java.util.Stack是用继承Vector来实现的。因此多了父类的很多方法，不是一个纯粹的栈了。

- Set不保存重复的元素。他和Collection具有完全一样的接口，没有增加一个方法。

- map

- linkedlist实现了Queue接口，可以将一个LinkedList转成Queue使用。java.util.PriorityQueue是优先级队列，在调用offer()方法添加元素的时候，会排序，可以使用Comparator接口自定义排序。
