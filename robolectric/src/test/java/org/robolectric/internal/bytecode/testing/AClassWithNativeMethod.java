package org.robolectric.internal.bytecode.testing;

import org.robolectric.annotation.internal.Instrument;

@SuppressWarnings("UnusedDeclaration")
@Instrument
public class AClassWithNativeMethod {
  public native String nativeMethod(String stringArg, int intArg);
}
