package Model;

/**
 * 迭代功能接口
 * 实现该接口允许对象成为 "foreach" 语句的目标。
 * 迭代返回一类的元素
 * @author Administrator
 *
 * @param <T>
 */
public interface IterableModel<T> {
	
	/*
	 * 返回一个在一组 T 类型的元素上进行迭代的迭代器。
	 */
	IteratorModel<T> iterator();

}
