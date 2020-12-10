// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.impl.source.tree.java.PsiJavaTokenImpl;
import io.github.jhipster.jdl.psi.JdlProperty;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class JdlLineMarkerProvider extends RelatedItemLineMarkerProvider {

  @Override
  protected void collectNavigationMarkers(@NotNull PsiElement element,
                                          @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
    // This must be an element with a literal expression as a parent
    if (!(element instanceof PsiJavaTokenImpl) || !(element.getParent() instanceof PsiLiteralExpression)) {
      return;
    }

    // The literal expression must start with the Simple language literal expression
    PsiLiteralExpression literalExpression = (PsiLiteralExpression) element.getParent();
    String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
    if ((value == null) ||
            !value.startsWith(JdlAnnotator.SIMPLE_PREFIX_STR + JdlAnnotator.SIMPLE_SEPARATOR_STR)) {
      return;
    }

    // Get the Simple language property usage
    Project project = element.getProject();
    String possibleProperties = value.substring(
            JdlAnnotator.SIMPLE_PREFIX_STR.length() + JdlAnnotator.SIMPLE_SEPARATOR_STR.length()
    );
    final List<JdlProperty> properties = JdlUtil.findProperties(project, possibleProperties);
    if (properties.size() > 0) {
      // Add the property to a collection of line marker info
      NavigationGutterIconBuilder<PsiElement> builder =
              NavigationGutterIconBuilder.create(JdlIcons.FILE)
                      .setTargets(properties)
                      .setTooltipText("Navigate to Simple language property");
      result.add(builder.createLineMarkerInfo(element));
    }
  }

}
