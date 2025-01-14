package com.kamikaze.docidset.utils;

import java.io.Serializable;

/** 
 * Utility class to provide integer arrays whose sizes can be changed dynamically
 * 
 * @author hao yan
 */

public class PForDeltaIntSegmentArray extends PrimitiveArray<int[]>  implements Serializable{

  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public PForDeltaIntSegmentArray(int len) {
    super(len);
  }

  public PForDeltaIntSegmentArray() {
    super();
  }
  
  protected Object buildArray(int len) {
    return new int[len][];
  }
  
  public void add(int[] val) {
    ensureCapacity(_count + 1);
    int[][] array = (int[][]) _array;
    array[_count] = val;
    _count++;
  }

  
  public void set(int index, int[] ref) {
    ensureCapacity(index);
    ((int[][])_array)[index] = ref;
    _count = Math.max(_count, index + 1);
  }

  public int[] get(int index) {
    return ((int[][])_array)[index];
  }
}
