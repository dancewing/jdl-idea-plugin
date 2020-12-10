// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl.psi;

import com.intellij.psi.tree.IElementType;
import io.github.jhipster.jdl.JdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class JdlElementType extends IElementType {

  public JdlElementType(@NotNull @NonNls String debugName) {
    super(debugName, JdlLanguage.INSTANCE);
  }

}
