package io.github.jhipster.jdl.ide.folding;

import com.intellij.codeInsight.folding.CodeFoldingSettings;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.CustomFoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.jhipster.jdl.JdlTokenTypes;
import io.github.jhipster.jdl.psi.JdlApplicationConfig;
import io.github.jhipster.jdl.psi.JdlApplicationConfigBody;
import io.github.jhipster.jdl.psi.JdlApplicationDefinition;
import io.github.jhipster.jdl.psi.JdlApplicationTypeBody;
import io.github.jhipster.jdl.psi.JdlComponent;
import io.github.jhipster.jdl.psi.JdlEntityDefinition;
import io.github.jhipster.jdl.psi.JdlEntityTypeBody;
import io.github.jhipster.jdl.psi.JdlEnumDefinition;
import io.github.jhipster.jdl.psi.JdlFile;
import io.github.jhipster.jdl.psi.JdlRelationshipBody;
import io.github.jhipster.jdl.psi.JdlRelationshipDefinition;
import io.github.jhipster.jdl.psi.JdlTypes;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JdlFoldingBuilder extends CustomFoldingBuilder implements DumbAware {

  private static final String SMILEY = "<~>";
  private static final String DOT_DOT_DOT = "...";
  private static final String BRACE_DOTS = "{...}";
  private static final String PAREN_DOTS = "(...)";
  private static final String FILE_HEADER = "/.../";
  private static final String MULTI_LINE_DOC_COMMENT = "/**...*/";
  private static final String MULTI_LINE_COMMENT = "/*...*/";
  private static final String SINGLE_LINE_DOC_COMMENT = "///...";
  private static final String SINGLE_LINE_COMMENT = "//...";

  private static final String TEST_METHOD_NAME = "test";
  private static final String GROUP_METHOD_NAME = "group";

  @Override
  protected boolean isCustomFoldingRoot(@NotNull final ASTNode node) {
    final IElementType type = node.getElementType();
    return type == JdlTokenTypes.JDL_FILE || type == JdlTypes.APPLICATION || type == JdlTypes.ENTITY;
  }

  @Override
  protected void buildLanguageFoldRegions(@NotNull final List<FoldingDescriptor> descriptors,
      @NotNull final PsiElement root,
      @NotNull final Document document,
      final boolean quick) {
    if (!(root instanceof JdlFile)) {
      return;
    }

    final JdlFile jdlFile = (JdlFile) root;
    final TextRange fileHeaderRange = foldFileHeader(descriptors, jdlFile, document); // 1. File header
    final Collection<PsiElement> psiElements = PsiTreeUtil.findChildrenOfAnyType(
        root,
        JdlComponent.class,
        PsiComment.class);
    foldComments(descriptors, psiElements, fileHeaderRange);                           // 4. Comments and comment sequences
    foldBodies(descriptors, jdlFile);                                            // 5. Class bodies
  }

  @Override
  @NotNull
  protected String getLanguagePlaceholderText(@NotNull final ASTNode node, @NotNull final TextRange range) {
    final IElementType elementType = node.getElementType();
    final PsiElement psiElement = node.getPsi();

    if (psiElement instanceof JdlFile) {
      return FILE_HEADER;                                      // 1.   File header
    }
    if (elementType == JdlTokenTypes.MULTI_LINE_DOC_COMMENT) {
      return MULTI_LINE_DOC_COMMENT; // 4.1. Multiline doc comments
    }
    if (elementType == JdlTokenTypes.MULTI_LINE_COMMENT) {
      return MULTI_LINE_COMMENT;         // 4.2. Multiline comments
    }
    if (elementType == JdlTokenTypes.SINGLE_LINE_DOC_COMMENT) {
      return SINGLE_LINE_DOC_COMMENT;                                                            // 4.3. Consequent single line doc comments
    }
    if (elementType == JdlTokenTypes.SINGLE_LINE_COMMENT) {
      return SINGLE_LINE_COMMENT;       // 4.4. Consequent single line comments
    }
    if (psiElement instanceof JdlEntityDefinition || psiElement instanceof JdlEnumDefinition) {
      return BRACE_DOTS;                                                                         // 5.   Class body
    }
    return DOT_DOT_DOT;
  }

  @Override
  protected boolean isRegionCollapsedByDefault(@NotNull final ASTNode node) {
    final IElementType elementType = node.getElementType();
    final PsiElement psiElement = node.getPsi();
    final CodeFoldingSettings settings = CodeFoldingSettings.getInstance();
    final JdlCodeFoldingSettings dartSettings = JdlCodeFoldingSettings.getInstance();

    if (psiElement instanceof JdlFile) {
      return settings.COLLAPSE_FILE_HEADER;                        // 1. File header
    }
    if (elementType == JdlTokenTypes.MULTI_LINE_DOC_COMMENT ||                                  // 4.1. Multiline doc comments
        elementType
            == JdlTokenTypes.SINGLE_LINE_DOC_COMMENT) {                                                // 4.3. Consequent single line doc comments
      return settings.COLLAPSE_DOC_COMMENTS;                                                         // 4.2 and 4.4 never collapsed by default
    }
    return false;
  }

  @Nullable
  private static TextRange foldFileHeader(@NotNull final List<FoldingDescriptor> descriptors,
      @NotNull final JdlFile jdlFile,
      @NotNull final Document document) {
    PsiElement firstComment = jdlFile.getFirstChild();
    if (firstComment instanceof PsiWhiteSpace) {
      firstComment = firstComment.getNextSibling();
    }

    if (!(firstComment instanceof PsiComment)) {
      return null;
    }

    boolean containsCustomRegionMarker = false;
    PsiElement nextAfterComments = firstComment;
    while (nextAfterComments instanceof PsiComment || nextAfterComments instanceof PsiWhiteSpace) {
      containsCustomRegionMarker |= isCustomRegionElement(nextAfterComments);
      nextAfterComments = nextAfterComments.getNextSibling();
    }

    if (nextAfterComments == null) {
      return null;
    }

    return null;
  }

  private static void foldComments(@NotNull final List<FoldingDescriptor> descriptors,
      @NotNull final Collection<PsiElement> psiElements,
      @Nullable final TextRange fileHeaderRange) {
    for (Iterator<PsiElement> iter = psiElements.iterator(); iter.hasNext(); ) {
      PsiElement psiElement = iter.next();
      if (!(psiElement instanceof PsiComment)) {
        continue;
      }
      if (fileHeaderRange != null && fileHeaderRange.intersects(psiElement.getTextRange())) {
        continue;
      }

      final IElementType elementType = psiElement.getNode().getElementType();
      if ((elementType == JdlTokenTypes.MULTI_LINE_DOC_COMMENT || elementType == JdlTokenTypes.MULTI_LINE_COMMENT) &&
          !isCustomRegionElement(psiElement)) {
        descriptors.add(new FoldingDescriptor(psiElement, psiElement.getTextRange()));
      } else if (elementType == JdlTokenTypes.SINGLE_LINE_DOC_COMMENT || elementType == JdlTokenTypes.SINGLE_LINE_COMMENT) {
        final PsiElement firstCommentInSequence = psiElement;
        PsiElement lastCommentInSequence = firstCommentInSequence;
        PsiElement nextElement = firstCommentInSequence;
        boolean containsCustomRegionMarker = isCustomRegionElement(nextElement);
        while (iter.hasNext() && (nextElement = nextElement.getNextSibling()) != null &&
            (nextElement instanceof PsiWhiteSpace || nextElement.getNode().getElementType() == elementType)) {
          if (nextElement.getNode().getElementType() == elementType) {
            // advance iterator to skip processed comments sequence
            iter.next();
            lastCommentInSequence = nextElement;
            containsCustomRegionMarker |= isCustomRegionElement(nextElement);
          }
        }

        if (lastCommentInSequence != firstCommentInSequence && !containsCustomRegionMarker) {
          final TextRange range =
              TextRange.create(firstCommentInSequence.getTextRange().getStartOffset(), lastCommentInSequence.getTextRange().getEndOffset());
          descriptors.add(new FoldingDescriptor(firstCommentInSequence, range));
        }
      }
    }
  }

  private static void foldBodies(@NotNull final List<FoldingDescriptor> descriptors, @NotNull final JdlFile jdlFile) {
    for (PsiElement element : PsiTreeUtil.getChildrenOfAnyType(jdlFile, JdlComponent.class)) {
      if (element instanceof JdlEntityDefinition) {
        final JdlEntityTypeBody body = ((JdlEntityDefinition) element).getEntityTypeBody();
        if (body != null && body.getTextLength() > 2) {
          descriptors.add(new FoldingDescriptor(body, body.getTextRange()));
        }
      } else if (element instanceof JdlEnumDefinition) {
        final ASTNode lBrace = element.getNode().findChildByType(JdlTypes.LBRACE);
        final ASTNode rBrace = element.getNode().findChildByType(JdlTypes.RBRACE, lBrace);
        if (lBrace != null && rBrace != null && rBrace.getStartOffset() - lBrace.getStartOffset() > 2) {
          descriptors.add(new FoldingDescriptor(element, TextRange.create(lBrace.getStartOffset(), rBrace.getStartOffset() + 1)));
        }
      } else if (element instanceof JdlRelationshipDefinition) {
        final JdlRelationshipBody body = ((JdlRelationshipDefinition) element).getRelationshipBody();
        if (body.getTextLength() > 2) {
          descriptors.add(new FoldingDescriptor(body, body.getTextRange()));
        }
      } else if (element instanceof JdlApplicationDefinition) {
        final JdlApplicationTypeBody body = ((JdlApplicationDefinition) element).getApplicationTypeBody();
        if (body.getTextLength() > 2) {
          descriptors.add(new FoldingDescriptor(body, body.getTextRange()));
        }
      } else if (element instanceof JdlApplicationConfig) {
        final JdlApplicationConfigBody body = ((JdlApplicationConfig) element).getApplicationConfigBody();
        if (body.getTextLength() > 2) {
          descriptors.add(new FoldingDescriptor(body, body.getTextRange()));
        }
      }

    }
  }
}
