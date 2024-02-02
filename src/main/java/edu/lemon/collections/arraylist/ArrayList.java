package edu.lemon.collections.arraylist;

import edu.lemon.collections.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
  private static final int BEGIN_SIZE = 8;
	private static final double LOAD_FACTOR = 0.7;
  private Object[] objects;
  private int size;

  public ArrayList() {
    this.objects = new Object[BEGIN_SIZE];
    this.size = 0;
  }

  public ArrayList(E[] array) {
		if (array.length > size) {
			size = array.length;
			objects = Arrays.copyOf(array,size);
		} else {
			objects = Arrays.copyOfRange(array, 0, array.length);
		}
  }

	public int size() {
		return size;
	}

	@Override
  public void add(E object) {
		int effectiveSize = objects.length;
		double effectiveLoadedCoefficient = (double) size / (double) effectiveSize;
		if (effectiveLoadedCoefficient >= LOAD_FACTOR) {
      objects = Arrays.copyOfRange(objects, 0,effectiveSize * 2);
    }

    objects[size] = object;
    size++;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E[] toArray() {
    return (E[])Arrays.copyOf(objects, size);
  }

	@Override
	public String toString() {
		return Arrays.toString(objects);
	}
}
