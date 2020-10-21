package com.outbrain.ci.friendly.flatten.maven.plugin.visitor;

public interface PomVisitor {
  default String visit(final String originalPom, final String revision, String sha1, String changeList){
    String modified;
    modified = originalPom.replace("${revision}", revision);
    if (originalPom.contains("${sha1}")) {
      modified = modified.replace("${sha1}", sha1 != null ? sha1 : "");
    }

    if (originalPom.contains("${changelist}")) {
      modified = modified.replace("${changelist}", changeList != null ? changeList : "");
    }

    return modified;
  }
}
