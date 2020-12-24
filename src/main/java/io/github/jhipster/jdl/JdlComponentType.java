// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package io.github.jhipster.jdl;

import com.intellij.icons.AllIcons;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.jhipster.jdl.psi.JdlClass;
import io.github.jhipster.jdl.psi.JdlComponent;
import io.github.jhipster.jdl.psi.JdlComponentName;
import io.github.jhipster.jdl.psi.JdlEnumConstantDeclaration;
import io.github.jhipster.jdl.psi.JdlEnumDefinition;
import java.util.function.Supplier;
import javax.swing.Icon;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum JdlComponentType {
  CLASS(AllIcons.Nodes.Class, JdlBundle.messagePointer("find.usages.type.class")),
  FUNCTION(AllIcons.Nodes.Lambda, JdlBundle.messagePointer("find.usages.type.function")),
  LOCAL_VARIABLE(AllIcons.Nodes.Variable, JdlBundle.messagePointer("find.usages.type.local.variable")),
  FIELD(AllIcons.Nodes.Field, JdlBundle.messagePointer("find.usages.type.field")),
  PARAMETER(AllIcons.Nodes.Parameter, JdlBundle.messagePointer("find.usages.type.parameter")),
  TYPEDEF(AllIcons.Nodes.Annotationtype, JdlBundle.messagePointer("find.usages.type.typedef")),
  CONSTRUCTOR(AllIcons.Nodes.Method, JdlBundle.messagePointer("find.usages.type.constructor")),
  OPERATOR(AllIcons.Nodes.ClassInitializer, JdlBundle.messagePointer("find.usages.type.operator")),
  LABEL(AllIcons.Nodes.Variable, JdlBundle.messagePointer("find.usages.type.label"));

  private final Icon myIcon;
  private final Supplier<@Nls String> myUsageTypeSupplier;

  JdlComponentType(final Icon icon, Supplier<@Nls String> supplier) {
    myIcon = icon;
    myUsageTypeSupplier = supplier;
  }

  public int getKey() {
    return ordinal();
  }

  public Icon getIcon() {
    return myIcon;
  }

  public Icon getIcon(@NotNull JdlComponent component) {
    // Overridden in appropriate subclasses
    return getIcon();
  }

  public @NotNull @Nls String getUsageType() {
    return myUsageTypeSupplier.get();
  }

  @Nullable
  public static JdlComponentType valueOf(int key) {
    return key >= 0 && key < values().length ? values()[key] : null;
  }

  @Nullable
  public static JdlComponentType typeOf(@Nullable PsiElement element) {
    if (element instanceof JdlComponentName) {
      return typeOf(element.getParent());
    }
//    if ((element instanceof JdlComponent && PsiTreeUtil.getParentOfType(element, DartNormalFormalParameter.class, false) != null) ||
//        element instanceof DartNormalFormalParameter) {
//      return PARAMETER;
//    }
    if (element instanceof JdlClass) {
      return CLASS;
    }
    if (element instanceof JdlEnumConstantDeclaration) {
      return FIELD;
    }
//    if (element instanceof DartFunctionFormalParameter
//        || element instanceof DartFunctionDeclarationWithBody
//        || element instanceof DartFunctionDeclarationWithBodyOrNative
//        || element instanceof DartFunctionExpression) {
//      return FUNCTION;
//    }
//
//    if (element instanceof DartVarAccessDeclaration || element instanceof DartVarDeclarationListPart) {
//      JdlComponent parentComponent = PsiTreeUtil.getParentOfType(element, JdlComponent.class);
//      JdlComponentType parentType = typeOf(parentComponent);
//      if (parentType == CLASS) return FIELD;
//      if (parentType == CONSTRUCTOR || parentType == METHOD || parentType == FUNCTION || parentType == OPERATOR) return LOCAL_VARIABLE;
//      return GLOBAL_VARIABLE;
//    }
//
//    if (element instanceof DartForInPart) {
//      return LOCAL_VARIABLE;
//    }
//
//    if (element instanceof DartLabel) {
//      return LABEL;
//    }

    return null;
  }
}
