// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl;

import com.intellij.lang.Language;

public class JdlLanguage extends Language {

  public static final JdlLanguage INSTANCE = new JdlLanguage();

  private JdlLanguage() {
    super("Jdl");
  }

}
