package org.robolectric.util;

import java.lang.ref.SoftReference;

public abstract class SoftThreadLocal<T> {
  private final ThreadLocal<SoftReference<T>> threadLocal = new ThreadLocal<SoftReference<T>>() {
    protected SoftReference<T> initialValue() {
      return new SoftReference<>(create());
    }
  };

  synchronized public T get() {
    T item = threadLocal.get().get();
    if (item == null) {
      item = create();
      threadLocal.set(new SoftReference<>(item));
    }
    return item;
  }

  public void set(T item) {
    threadLocal.set(new SoftReference<>(item));
  }

  abstract protected T create();
}
